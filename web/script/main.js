const registerLink = document.getElementById("register-link");
const loginLink = document.getElementById("login-link");
const wrapper = document.querySelector(".wrapper");


/*Thêm sự kiện click cho thẻ a register-link*/
registerLink.addEventListener('click', () => {
    wrapper.classList.add('active');
});

/*Thêm sự kiện click cho thẻ a login-link*/
loginLink.addEventListener('click', () => {
    wrapper.classList.remove('active');
});




