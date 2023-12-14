const registerLink = document.getElementById("register-link");
const loginLink = document.getElementById("login-link");
const wrapper = document.querySelector(".wrapper");
const btnLogin = document.getElementById("Login");
const iconClosed = document.querySelector(".icon_closed");

/*Thêm sự kiện click cho thẻ a register-link*/
registerLink.addEventListener('click', () => {
    wrapper.classList.add('active');
});

/*Thêm sự kiện click cho thẻ a login-link*/
loginLink.addEventListener('click', () => {
    wrapper.classList.remove('active');
});



