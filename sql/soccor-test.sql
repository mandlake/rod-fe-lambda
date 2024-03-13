-- 001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오.

select * from team order by team_name asc;

-- 002. 플레이어의 포지션 종류를 나열하시오. 단, 증복은 제거하고, 포지션이 없으면 빈 공간으로 두시오.

select distinct POSITION from player;

-- 003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오

SELECT distinct
    case
        when position='' then '신입'
        else position
    end position FROM Player ;

-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.

select player_name from Player where position = 'GK' and team_id = 'K02';

-- 004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 팀 ID를 모를 때

select player_name from Player where position = 'GK' and team_id = (select team_id
                                                                    from team
                                                                    where region_name = '수원');

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.

select player_name from Player where team_id = 'K02' and player_name like '고%' and height >= 170;

-- 005-1. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 팀 ID를 모를 때

select player_name from Player where team_id = (select team_id
                                                from team
                                                where region_name = '수원')
                               and player_name like '고%' and height >= 170;

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.

select player_name from player where team_id in (select team_id
                                                 from team
                                                 where team_name in ('삼성블루윙즈', '드래곤즈'))
                               and position = 'MF'
                               and height between 170 and 180;

-- 문제 7
-- 수원을 연고지로 하는 골키퍼는 누구인가?

select player_name from player where team_id = (select team_id
                                                from team
                                                where region_name ='수원')
                               and position = 'GK';

-- 문제 8
-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오

select player_name,
    case
        when height='' then '0'
        else height
    end height,
    case
        when weight='' then '0'
        else weight
    end weight from player where team_id = (select team_id
                                            from team
                                            where region_name ='서울');

-- 문제 9
-- 서울팀 선수들 이름과 포지션과
-- 키(cm 표시)와 몸무게(kg 표시)와  각 선수의 BMI 지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오
-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름내림차순으로 정렬하시오

select player_name, position,
    concat(
        case
            when height='' then '0'
            else height
        end, 'cm') as height,
    concat(
        case
            when weight='' then '0'
            else weight
        end, 'kg') as weight,
    case
        when height='' or weight='' then 'NONE'
        else ROUND(weight / ((height / 100) * (height / 100)), 2)
    end bmi from player where team_id = (select team_id
                                         from team
                                         where region_name ='서울') order by player_name desc;

-- full scan
-- 4개의 테이블을 모두 조인하세요.
-- 카티전 프로덕트 - 비추

select count(*)
from stadium s
    join team t using (stadium_id)
    join player p using (team_id)
    join schedule sc using (stadium_id);

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 포지션이 골키퍼(GK) 인 선수를 출력하시오
-- 단, 팀명, 선수명 오름차순 정렬하시오

select team_name, player_name
from player p
     join team t on t.team_id = p.team_id
where region_name in ('수원', '대전') and POSITION = 'GK'
order by 1, 2 asc;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- 수원 [팀 명]삼성블루윙즈 [홈구장]수원월드컵경기장

select concat (t.region_name, ' ' , t.team_name) as 팀명, concat( s.stadium_name, '') as 홈구장
from team t join stadium s using (stadium_id)
where region_name like '수원%';

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순

select p.height, t.team_name, p.player_name
from Player p join team t using (team_id)
where region_name in ('수원', '대전') and height between 180 and 183
order by 1, 2, 3 asc;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순

select t.team_name, p.player_name
from Player p join team t using (team_id)
where POSITION = ''
order by 1, 2 asc;

-- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.

select t.team_name, s.stadium_name, t2.team_name
from stadium s
    join team t on s.stadium_id = t.stadium_id
    join schedule sc on s.stadium_id = sc.stadium_id
    JOIN team t2 ON t2.team_id = sc.awayteam_id
where sc.sche_date = '20120317';

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)

select player_name, position, concat(region_name, ' ', team_name) as '팀 명', stadium_name, sche_date
from stadium s
    join team t on s.stadium_id = t.stadium_id
    join player p on t.team_id = p.team_id
    join schedule sc on s.stadium_id = sc.stadium_id
where region_name = '포항' and position = 'GK' and sche_date = 20120317;

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오

select s.stadium_name,
       sc.sche_date,
       (select t.team_name from team t where sc.awayteam_id = t.team_id) as '원정 팀',
       (select t.team_name from team t where sc.hometeam_id = t.team_id) as '홈 팀'
from stadium s
    join team t using (stadium_id)
    join schedule sc using (stadium_id)
where sc.home_score - sc.away_score >= 3;

-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함

select st.stadium_name, (SELECT t.team_name
                         from team t
                         where t.stadium_id = st.stadium_id) as '팀'
from stadium st;

select st.stadium_name, t.team_name
from stadium st left join team t using (stadium_id);

-- 문제 18 플레이어 테이블에서 최상단 5개 로우를 출력

select * from player LIMIT 5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 - 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.

select t.team_id,
       t.team_name,
       (select round(avg(height),2) from player where t.team_id = team_id) as '평균 키'
from team t
where (select round(avg(height),2) from player where t.team_id = team_id) <
      (select round(avg(height),2) from player where team_id = 'k04')
group by team_id, team_name;

-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력

select
    (select t.team_name from team t where t.team_id = p.team_id) as '소속 팀명',
    p.player_name as '선수 명',
    p.back_no as '백 넘버'
from Player p
where p.`POSITION` = 'MF';

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키 값이 없으면 제외

select
    (select t.team_name from team t where t.team_id = p.team_id) as '소속 팀명',
     p.player_name as '선수 명',
     p.back_no as '백 넘버'
from Player p
where height is not null
order by height desc
limit 5;

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)

select *
from Player p
where p.height < (select round(avg(height),2) from player where team_id = p.team_id);

-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장 조회

select (select st.stadium_name from stadium st where st.stadium_id = s.stadium_id) as '경기장'
from schedule s
where s.sche_date between 20120501 and 20120531;