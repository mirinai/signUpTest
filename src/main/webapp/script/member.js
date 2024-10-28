/**
 * 
 */
function loginCheck() {
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("비밀번호를 써주세요");
		frm.pwd.focus();
		return false;
	}
	return true;
}

const idCheck = () => {
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 넣어주세요");
		document.frm.userid.focus();
		return;
	}
	const url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank1_", "toolbar=no, menubar=no, scrollbar=yes, resizable=no, width=450, height=200")
}

const idok = () => {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck() {
	if (document.frm.name.value == "") {
		alert("이름을 써주세요");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("아이디는 4글자 이상이어야 함");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("비밀번호를 써주세요");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd.pwd_check.value) {
		alert("비밀번호가 서로 다름");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length==0) {
			alert("중복체크를 안함");
			frm.reid.focus();
			return false;
		}
}