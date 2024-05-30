// // 회원가입 입력 검증 처리

// // 계정 중복검사 비동기 요청 보내기
// async function fetchDuplicate(idValue) {
//   const res = await fetch(
//     `http://localhost:8383/members/check?type=account&keyword=${idValue}`
//   );

//   const flag = await res.json();

//   idFlag = flag;
// }

// // 이메일 중복검사 비동기 요청 보내기
// async function fetchDuplicateEmail(emailValue) {
//   const res = await fetch(
//     `http://localhost:8383/members/check?type=email&keyword=${emailValue}`
//   );

//   const flag = await res.json();

//   emailFlag = flag;
// }

// // 계정 입력 검증
// const $idInput = document.getElementById("user_id");
// const $pwInput = document.getElementById("password");
// const $pwInput2 = document.getElementById("password_check");
// const $nameInput = document.getElementById("user_name");
// const $emailInput = document.getElementById("user_email");
// let idFlag = false;
// let emailFlag = false;

// $idInput.addEventListener("keyup", async (e) => {
//   // 아이디 검사 정규표현식
//   const accountPattern = /^[a-zA-Z0-9]{4,14}$/;

//   // 입력값 읽어오기
//   const idValue = $idInput.value;

//   console.log(idValue);
//   // 검증 메시지를 입력할 span
//   const $idChk = document.getElementById("idChk");

//   if (idValue.trim() === "") {
//     console.log("아이디는 필수입니다^^");
//     $idInput.style.borderColor = "red";
//     $idChk.innerHTML = '<b class="warning">[아이디는 필수값입니다^^]</b>';
//   } else if (!accountPattern.test(idValue)) {
//     console.log("아이디는 영문의 4~14글자 사이");
//     $idInput.style.borderColor = "red";
//     $idChk.innerHTML =
//       '<b class="warning">[아이디는 4~14글자 사이 영문,숫자로 입력하세요]</b>';
//   } else {
//     // 아이디 중복검사
//     await fetchDuplicate(idValue);

//     if (idFlag) {
//       $idInput.style.borderColor = "red";
//       $idChk.innerHTML = '<b class="warning">[아이디가 중복입니다.]</b>';
//     } else {
//       console.log("정상 입력");
//       $idInput.style.borderColor = "skyblue";
//       $idChk.innerHTML = '<b class="success">[사용 가능한 아이디입니다.]</b>';
      
//     }
//   }
//   await checkAllInfo();
// });

// $pwInput.addEventListener("keyup", async (e) => {
//   // 패스워드 검사 정규표현식
//   const passwordPattern =
//     /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/;

//   // 비밀번호 입력값 읽어오기
//   const pwValue = $pwInput.value;
//   //   const pwValue2 = $pwInput2.value;

//   console.log(pwValue);
//   // 검증 메시지를 입력할 span
//   const $pwChk = document.getElementById("pwChk");

//   if (!passwordPattern.test(pwValue)) {
//     console.log("비밀번호 형식에 맞게 입력해주세요^^");
//     $pwInput.style.borderColor = "red";
//     $pwChk.innerHTML =
//       '<b class="warning">[비밀번호 형식에 맞게 입력해주세요^^]</b>';
//   } else if (passwordPattern.test(pwValue)) {
//     console.log("정상 입력");
//     $pwInput.style.borderColor = "skyblue";
//     $pwChk.innerHTML = '<b class="success">[사용 가능한 비밀번호입니다.]</b>';
//     checkMatchPw(pwValue);
//   }
//   await checkAllInfo();
// });

// function checkMatchPw(pwValue) {
//   $pwInput2.addEventListener("keyup", async (e) => {
//     // 패스워드 검사 정규표현식
//     const passwordPattern =
//       /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/;

//     // 비밀번호 입력값 읽어오기
//     const pwValue2 = $pwInput2.value;

//     // 검증 메시지를 입력할 span
//     const $pwChk = document.getElementById("pwChk");

//     if (pwValue2 !== pwValue) {
//       console.log("비밀번호 불일치");
//       $pwInput.style.borderColor = "red";
//       $pwChk.innerHTML =
//         '<b class="warning">[비밀번호가 일치하지않습니다.]</b>';
//     } else if (passwordPattern.test(pwValue2) && pwValue2 === pwValue) {
//       console.log("정상 입력");
//       $pwInput.style.borderColor = "skyblue";
//       $pwChk.innerHTML = '<b class="success">[사용 가능한 비밀번호입니다.]</b>';
     
//     }
//     await checkAllInfo();
//   });
// }

// $nameInput.addEventListener("keyup", async (e) => {
//   // 이름 검사 정규표현식
//   const namePattern = /^[가-힣]+$/;

//   // 이름 입력값 읽어오기
//   const nameValue = $nameInput.value;
//   //   const pwValue2 = $pwInput2.value;

//   console.log(nameValue);
//   // 검증 메시지를 입력할 span
//   const $nameChk = document.getElementById("nameChk");

//   if (!namePattern.test(nameValue)) {
//     console.log("이름을 정확히 입력해주세요^^");
//     $nameInput.style.borderColor = "red";
//     $nameChk.innerHTML =
//       '<b class="warning">[이름을 정확히 입력해주세요^^]</b>';
//   } else {
//     console.log("이름 정상입력^^");
//     $nameInput.style.borderColor = "skyblue";
//     $nameChk.innerHTML = '<b class="success">[사용 가능^^]</b>';
//   }
//   await checkAllInfo();
// });

// $emailInput.addEventListener("keyup", async (e) => {
//   // 이메일 검사 정규표현식
//   const emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

//   // 이름 입력값 읽어오기
//   const emailValue = $emailInput.value;

//   // 검증 메시지를 입력할 span
//   const $emailChk = document.getElementById("emailChk");

//   if (emailValue.trim() === "") {
//     console.log("이메일은 필수입니다^^");
//     $emailInput.style.borderColor = "red";
//     $emailChk.innerHTML = '<b class="warning">[이메일은 필수값입니다^^]</b>';
//   } else if (!emailPattern.test(emailValue)) {
//     console.log("이메일을 정확히 입력해주세요^^");
//     $emailInput.style.borderColor = "red";
//     $emailChk.innerHTML =
//       '<b class="warning">[이메일을 정확히 입력해주세요^^]</b>';
//   } else {
//     await fetchDuplicateEmail(emailValue);

//     if (emailFlag) {
//       $emailInput.style.borderColor = "red";
//       $emailChk.innerHTML = '<b class="warning">[이메일이 중복입니다.]</b>';
//     } else {
//       console.log("이메일 정상입력^^");
//       $emailInput.style.borderColor = "skyblue";
//       $emailChk.innerHTML = '<b class="success">[사용 가능^^]</b>';

      
//     }
//   }
//   await checkAllInfo();
// });

// async function checkAllInfo() {
//   if (
//     $idInput.style.borderColor === "skyblue" &&
//     $pwInput.style.borderColor === "skyblue" &&
//     $nameInput.style.borderColor === "skyblue" &&
//     $emailInput.style.borderColor === "skyblue"
//   ) {
//     document.getElementById("signup-btn").disabled = false;
//     document.getElementById("signup-btn").style.backgroundColor = "lightgreen"
//     console.log("회원가입 활성화");
//   } else {
//     document.getElementById("signup-btn").disabled = true;
//     document.getElementById("signup-btn").style.backgroundColor = "gray"
//   }
// }
