// window.addEventListener("scroll", () => {
//   const navbar = document.querySelector(".header-container");
//   const scrollHeight = window.pageYOffset;
//   const navHeight = navbar.getBoundingClientRect().height;
//   if (scrollHeight > navHeight) {
//     navbar.classList.add("fixed-nav");
//   } else {
//     navbar.classList.remove("fixed-nav");
//   }
// });

const introBtns = document.querySelectorAll(".intro-btn");

introBtns.forEach(introBtn => {
  introBtn.addEventListener("click", () => {
    introBtn.classList.add("active");

    var introDesc = introBtn.nextElementSibling;
    if (introDesc.style.display === "block") {
      introDesc.style.display = "none";
    } else {
      introDesc.style.display = "block";
    }
  });
});
