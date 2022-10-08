# Collaborative Filtering - Matrix Factorization
추천시스템 알고리즘 중 collaborative filtering - matrix factorization을 구현하는 코드입니다.  

## Install
- sklearn
- scipy
- surprise
- pyspark

## 내용
### 폴더 설명
- SVD (Singular Value Decomposition)  
- SGD (Stochastic Gradient Descent)  
- ALS (Alternation Least Squares)  

추천 시스템을 구현하는 알고리즘 세 가지 각각에 대한 파일들입니다.  

### 파일 세부 설명 및 실행 결과
각 파일이 포함하는 내용은 다음과 같습니다.
- model train / test : RMSE 측정을 위한 train, test 과정
- 최적의 값 k(feature 개수) 찾기
- predict : 전체 데이터에 대해 모든 user의 모든 cafe에 대한 rating predict 값 구하기 (user-cafe matrix 구하기)
- recommender : predict된 값을 바탕으로, user에게 카페 추천

## Reference  
**SVD**  
- https://hanshuginn.blogspot.com/2021/04/svd-python-svdsingular-value.html  
- https://github.com/lsjsj92/recommender_system_with_Python/  

**SGD**
- https://github.com/SebastianRokholt/Hybrid-Recommender-System/blob/main/analysis-and-modelling.ipynb  

**ALS**
- https://github.com/abhilashhn1993/collaborative-filtering-using-ALS-for-movie-recommendation  
- https://grabngoinfo.com/install-pyspark-3-on-google-colab-the-easy-way/  
