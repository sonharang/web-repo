//function.js
 //함수 정의 방법
        //1. 함수 선언
        function myFunc(std, score //score = 0 ->초기값 0으로 설정
        ){
          if(score ==undefined){
            // score = 0;
            score = "없습니다."
          }
            console.log(`${std}의 점수는 ${score}`);
            return score; //리턴 구문 없으면 undefined
        }
        myFunc("홍길동", 95);
        myFunc("전우치")
        console.log("======");
        
        //2. 함수 표현식
        var myFunc = function myFunc(std, score = 0){
            console.log(`${std}의 점수는 ${score}`);
            return std + "의 점수는 : " +score; //리턴 구문 없으면 undefined
        }
        console.log(myFunc("홍길동"));
        console.log("======");
        myFunc("홍길동");