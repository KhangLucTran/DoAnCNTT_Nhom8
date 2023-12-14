function toast( {
title = '',
        message = '',
        type = '',
        duration = 3000}) {
    const main = document.getElementById('toast');

    if (main) {
        const toast = document.createElement('div');
        toast.onclick = function (e) {
            if (e.target.closest('.toast__close')) {
                main.removeChild(toast);
            }
        };
        const icons = {
            success: 'fa-solid fa-circle-check',
            infor: 'fa-solid fa-circle-info',
            warning: 'fa-solid fa-triangle-exclamation',
            error: 'fas fa-exclamation-circle'
        };
        const icon = icons[type];
        const delay = (duration / 1000).toFixed(2);

      toast.classList.add('toast', `toast--${type}`);
toast.style.animation = `slideInLeft ease 0.5s, fadeOut linear 1s ${delay}s forwards`;

        toast.innerHTML = `
                    <div class="toast__icon">
                    <i class="${icon}"></i>       
                    </div>
                    <div class="toast__body">
                        <h3 class="toast__title">${title}</h3>
                        <p class="toast__msg">${message}</p>     
                    </div>
                    <div class="toast__close">
                        <i class="fa-solid fa-xmark"></i>
                    </div>`;

        main.appendChild(toast);

        setTimeout(function () {
            main.removeChild(toast);
        }, duration + 1000);
}
}

function showErrorToast(infor) {
    toast({
        title: 'Error',
        message: infor,
        type: 'error',
        duration: 5000
    });
}
function showSuccessToast(infor) {
    toast({
        title: 'Success',
        message: infor,
        type: 'success',
        duration: 5000
    });
}
function checkLogin() {
    var email = document.getElementById('emailLogin').value;
    var password = document.getElementById('passwordLogin').value;
    if (email == "" || password == "") {
        showErrorToast("Vui lòng nhập đầy đủ thông tin");
    } else if (isGmailAddress(email) == false) {
        alert("Vui lòng nhập đúng định dạng Email: @gmail.com !");
    } else {
        alert("Đăng nhập thành công");
    }
}
function isGmailAddress(email) {
    // Kiểm tra xem email có phải là địa chỉ Gmail hay không
    var pattern = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;
    if (email.includes("@gmail.com")) {
        return pattern.test(email);
    } else {
        return false;
    }
}
function checkRegister() {
    var email = document.getElementById('emailRe').value;
    var password = document.getElementById('passwordRe').value;
    var passwordEd = document.getElementById('passwordedRe').value;
    if (email == "" || password == "" || passwordEd == "") {
        showErrorToast("Vui lòng nhập đầy đủ thông tin!");
    } else if (isGmailAddress(email) == false) {
        alert("VinTravel");
        showErrorToast("Vui lòng nhập đúng định dạng Email: @gmail.com!");
    } else if (password != passwordEd) {
        alert("Vui lòng nhập đúng Password");
    } else {
        if (email.includes("admin")) {
            showSuccessToast("Bạn đã đăng kí thành công tài khoản Admin");
            alert("Bạn đã đăng kí thành công tài khoản Admin");
        } else {
            showSuccessToast("Bạn đã đăng kí thành công tài khoản User");
            alert("Bạn đã đăng kí thành công tài khoản User");
        }
    }
}
function  checkUserInfor(){
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var numberphone = document.getElementById('numberphone').value;
    var locate = document.getElementById('locate').value;
    var address = document.getElementById('address').value;
    
    if(firstname=="" || lastname=="" || numberphone=="" || locate=="" || address==""){
        showErrorToast("Vui lòng nhập thông tin đầy đủ!");
        firstname.focus();
        return;
    } else if(checkName(firstname)==false){
        alert("Vui lòng nhập FirstName không có kí tự số!");
        return;
    } else if(checkName(lastname)==false){
        alert("Vui lòng nhập LastName không có kí tự số!");
        return;
    } else if(isValidPhoneNumber(numberphone)==false){
        alert("Vui lòng nhập đúng định dạng số điện thoại!");
        return;
    } else{
        alert("Chỉnh sửa thông tin thành công!");
    }
}
function checkName(name) {
    if (typeof name !== 'string') {
        return false;
    }
    if (/\d/.test(name)) {
        return false;
    }
    return true;
}
function isValidPhoneNumber(phoneNumber) {
    // Chuyển phoneNumber thành số
    var number = parseInt(phoneNumber, 10);

    // Kiểm tra xem phoneNumber có phải là số không và không nhỏ hơn 0
    if (isNaN(number) || number < 0) {
        return false;
    }

    // Nếu không có vấn đề gì, trả về true
    return true;
}
