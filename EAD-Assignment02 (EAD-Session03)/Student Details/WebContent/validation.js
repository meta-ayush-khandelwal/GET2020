function validateFirstName() {
    var firstName = document.getElementById("firstName").value;
    if (firstName.length === 0) {
        document.getElementById("validationMessage").innerHTML = "First Name can't be empty";
        return false;
    }
    if (firstName.length <= 2) {
        document.getElementById("validationMessage").innerHTML = "First name length must be greater than 2";
        return false;
    }
    if (/^[A-Za-z]+$/.test(firstName)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = "Entered first name is not valid";
        return false;
    }
}

function validateLastName() {
    var lastName = document.getElementById("lastName").value;
    if (/^[A-Za-z ]+$/.test(lastName)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } 
    
    if (firstName.length === 0) {
        document.getElementById("validationMessage").innerHTML = "First Name can't be empty";
        return true;
    }
    document.getElementById("validationMessage").innerHTML = "Entered last name is not valid";
        return false;
    
}

function validateFatherName() {
    var fatherName = document.getElementById("fatherName").value;
    if (fatherName.length === 0) {
        document.getElementById("validationMessage").innerHTML = "Father Name can't be empty";
        return false;
    }

    if (/^[A-Za-z ]+$/.test(fatherName)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = "Entered father name is not valid";
        return false;
    }
}

function validateEmail() {
    var mail = document.getElementById("email").value;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    }
    if(mail.length===0){
    	document.getElementById("validationMessage").innerHTML = "Email can't be empty";
        return false;
    }
    document.getElementById("validationMessage").innerHTML = "Please enter a valid e-mail address!!";
    return false;
}

function validateAge(){
	var age=document.getElementById("age").value;
	if(age<1 && age>100){
		document.getElementById("validationMessage").innerHTML = "Age can be between 1 to 100!!";
	    return false;
	}
	else{
		document.getElementById("validationMessage").innerHTML = "";
        return true;
	}
}

function checkInputs(){
	if(validateFirstName() && validateLastName() && validateFatherName() && validateEmail() && validateAge()){
		document.getElementById("validationMessage").innerHTML = "";
        return true;
	}
	else{
		document.getElementById("validationMessage").innerHTML = "Check Inputs!!!";
	    return false;
	}
}

function isValid(){
	if(validateFirstName() && validateLastName()){
		document.getElementById("validationMessage").innerHTML = "";
        return true;
	}
	else{
		document.getElementById("validationMessage").innerHTML = "Check Inputs!!!";
	    return false;
	}
}