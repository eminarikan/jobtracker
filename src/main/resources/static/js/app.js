var isNavbarProfileMenuOpen = false;
function toggleNavbarProfileMenu(){
	var menu = document.getElementById('navbarProfileMenu');
	if(isNavbarProfileMenuOpen){
		menu.classList.remove('block');
		menu.classList.add('hidden');
	}else{
		menu.classList.remove('hidden');
		menu.classList.add('block');
	}
	isNavbarProfileMenuOpen = !isNavbarProfileMenuOpen;
}
