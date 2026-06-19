const form=document.getElementById("register_form");
const username=document.getElementById("username");
const email=document.getElementById("email");
const password=document.getElementById("password");
const password=document.getElementById("password");
const confirmpassword=document.getElementById("password");


form.addEventListener("submit", function(e){
    alert("2222");

    if (checkEmail(email)!=true)
    {
        
        alert("Mail không đúng định dạng");
    }
});

function checkEmail(input) {


    const value = input.value.trim();
  

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,3}$/;
    /*
    Giải thích:
    ^: Bắt đầu chuỗi
    $: Kết thúc chuỗi
    [a-zA-Z0-9._%+-] các ký tự từ a-z, A-Z,0.9, sau đó có dấu.
    +: Lặp lại khối trước 1 hoặc nhiều lần (ít nhất 1 lần)
    [A-Za-z]{2,3} phần .com, .edu, .vn (chỉ được 2-3 ký  tự)

    

    */

    if (emailRegex.test(value)) {

        showSuccess(input);
        return true;

    } else {

        showError(input, "Email is not valid");
        return false;

    }
}




