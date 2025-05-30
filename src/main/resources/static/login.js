
/**パスワードアイコン表示/非表示処理 */
function togglePasswordVisibility() {
	const passwordInput = document.getElementById("password");
	const icon = document.getElementById("toggleIcon");
	if (passwordInput.type === "password") {
		passwordInput.type = "text";
		icon.classList.remove("fa-eye");
		icon.classList.add("fa-eye-slash");
	} else {
		passwordInput.type = "password";
		icon.classList.remove("fa-eye-slash");
		icon.classList.add("fa-eye");
	}
}

/**ログインエラー時 */