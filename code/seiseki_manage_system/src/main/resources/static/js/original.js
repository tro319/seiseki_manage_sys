


// ハンバーガーメニュー全体閉開処理

const ham = document.querySelector(".hamburgers-cover");

const spNav = document.getElementById("sp_nav");

const links = document.querySelectorAll(".hamburger-border");

ham.addEventListener("click", function() {
	
	ham.classList.toggle("click-on");
	
	spNav.classList.toggle("open");
	
});

links.forEach(function(link) {
	
	link.addEventListener("click", function() {
		
		ham.classList.remove("click-on");
		
		spNav.classList.remove("open");
		
	});
	
});


// セレクトボックス重複選択制御処理

document.addEventListener("DOMContentLoaded", () => {
	
  const selects = document.querySelectorAll(".subject-select");

  function isRealOption(option) {
    
    return option.value !== "" && option.textContent.trim() !== "";
	
  }

  function updateOptions() {
	
    const selectedValues = Array.from(selects)
      .map(s => s.value)
      .filter(v => v !== "");

    selects.forEach(select => {
		
      const currentValue = select.value;

      Array.from(select.options).forEach(option => {
		
        if (!isRealOption(option)) return;

        if (
          selectedValues.includes(option.value) &&
          option.value !== currentValue
        ) {
			
          option.disabled = true;
		  
        } else {
			
          option.disabled = false;
		  
        }
		
      });
	  
    });
	
  }

  selects.forEach(select => {
	
    select.addEventListener("change", updateOptions);
	
  });

  
  updateOptions();
  
});


