# Content-Based Filtering - Machine Learning
추천시스템 알고리즘 중 Content-Based filtering - Machine Learning을 구현하는 코드입니다.  
user별로, cafe의 features들을 바탕으로 rating을 예측하는 ML을 진행합니다.  
ML은, Linear regression, Lasso regression, Random Forest Regression, Support Vector Regression을 진행합니다.


## Install
- sklearn
- scipy

## 각 파일 설명
**1. CBF_ML_preprocess.ipynb**
- kakao data(rating)와 naver data(features)를 merge하는 과정  

**2. CBF_ML_model.ipynb**
- model train / test : RMSE 측정을 위한 train, test 과정
- model fine tuning : RMSE가 가장 작은 hyperparameter를 찾기 위한 과정
- predict : 전체 데이터에 대해 모든 user의 모든 cafe에 대한 rating predict 값 구하기 (user-cafe matrix 구하기)  

**3. CBF_ML_recommend.ipynb**
- model에서 predict한 결과를 바탕으로, user에게 카페를 추천  

**4. kakao_naver_review.csv**
- 1.이 완료된 data



## Reference
https://github.com/SebastianRokholt/Hybrid-Recommender-System/blob/main/analysis-and-modelling.ipynb
