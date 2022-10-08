# Data
전처리가 모두 완료된 data들의 모음입니다.


## 각 폴더 및 파일 설명
**1. kakao_data**
  - ratings.csv
    - user-cafe matrix를 만들기 위해 크롤링된 데이터에서 열 'name','address',’cafe’,'user_id','rating','review'만 추출
    - 크롤링된 데이터에서 한 user가 한 cafe에 rating을 2번 이상 한 경우, 가장 최신의 행을 사용
    - rows 49088, user 32622명, cafe 6785개
  - ratings_two.csv
    - ratings.csv에서, rating이 2개 이상 있는 user들
    - rows 23308, user 6824명, cafe 5165개
  - reviews_five.csv
    - ratings.csv에서, review가 2개 이상 있는 user들
    - rows 19512, user 5556명, cafe 4820개
  - users.csv
    - user 32622명에 대한 data
    - columns : ['user_id','user_name','user_review_num','user_rating_avg']

**2. naver_data**
- naver_review.csv
  - 크롤링해온 카페명과 도로명 주소가 unique한 경우의 리뷰 데이터
  - row 7661개
- naver_review_name.csv
  - naver_review.csv에서 소상공인 데이터셋에 적힌 카페명을 merge한 데이터

**3. public_data**
- publicdata_cafe_lastdrop.csv
  - raw_data/publicdata_cafe.csv 가 전처리된 이후의 데이터
