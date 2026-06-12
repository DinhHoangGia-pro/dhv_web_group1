<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<style>

body
{

    margin:0px;
}

input
{

     width:300px;
     height: 30px;
     /* border:rgb(106, 201, 207) 1px solid; */
}

label
{
    display:block;
}
.form_group
{
    display: block;
}

.form_group.error input
{
    border-color: red;
     

}

.form_group.success input
{
     border-color: darkseagreen;

}


</style>







<body>
    <div id="container" style="width: 100%; display: flex; justify-content: center;   ">

     

        <div style="width:1000px; height: 500px; background-color: beige;">

            <form id="register_form" >

            

                    <div class="form_group">
                        <label for="username">Username</label>
                        <input id="username"/>
                        <small></small>
                    </div>


                     <div class="form_group">
                        <label for="email">Email</label>
                        <input id="email"/>
                        <small></small>
                    </div>


                     <div class="form_group">
                        <label for="password">Password</label>
                        <input id="password"/>
                        <small></small>
                    </div>


                     <div class="form_group">
                        <label for="confirmpassword">Confirm Password</label>
                        <input id="confirmpassword"/>
                        <small></small>
                    </div>


                    <div>
                        <button type="submit">Register</button>
                    </div>
                </form>

        </div>

    </div>

</body>



<script>

const form=document.getElementById("register_form");
const username=document.getElementById("username");
const email=document.getElementById("email");
const password=document.getElementById("password");
const confirmpassword=document.getElementById("confirmpassword");

form.addEventListener("submit", function(e){
    
    e.preventDefault();
    var ok=true;
    ok=checkRequired([username,email,password,confirmpassword]);  

    ok=(ok && checkEmail(email));  

    ok=(ok && checkPasswordMatch(password,confirmpassword));
    
    
    

    if (ok)
    {
        alert("Đăng ký thành công!");
        form.reset();
        document.querySelectorAll(".form_group").forEach(phantu=>{
            phantu.className="form_group";
        });

        
    }
  
    
   
});


function checkRequired(arr)
{
    var ok=true;

    //Cach 1:

    
    //Cách 2:

    arr.forEach(input => {
        if (input.value.trim()==="")
        {
            ok=false;
            showError(input, "Ô này cần nhập liệu");
        }
        else
        {
             showSuccess(input);

        } 
    });





    return ok;
    
}

function checkEmail(input) {


    const value = input.value.trim();
  

    const emailRegex =
        /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,}$/;

    if (emailRegex.test(value)) {

        showSuccess(input);
        return true;

    } else {

        showError(input, "Email is not valid");
        return false;

    }
}


function checkPasswordMatch(input1, input2)
{
    var ok=true;
    if (input1.value===input2.value)
    {
        showSuccess(input1);
         showSuccess(input2);
         return true;
    }
    else
    {
        showError(input2, "Mật khẩu nhắc lại phải trùng");
        return false;
    }

    return ok;

}


function showSuccess(input)
{
    formgroup=input.parentElement;
    formgroup.className="form_group success";
}

function showError(input, message)
{
    formgroup=input.parentElement;
    formgroup.className="form_group error";
    var small=formgroup.querySelector("small");
    small.innerText=message;
    
}


</script>

</html>