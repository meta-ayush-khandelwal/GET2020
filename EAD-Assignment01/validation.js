var ID = Math.floor((Math.random() * 1000) + 1);
var selected;
var optionSelected;

function afterEmpFormValidation() {
    if ((validateFullName() && validateGender() && validateEmail() && validatePassword() && validateConfirmPassword() && validateContact())) {
        document.getElementById("empForm").innerHTML = "<h2>Congratulations!!! You are successfully registered. Your Id is " + ID + "</h2>";
        var empID = document.getElementById("empId");
        empID.value = ID + "";
        document.getElementById("vehicleForm").style.display = "block";
    } else
        document.getElementById("validationMessage").innerHTML = "Check your inputs";
}

function validateFullName() {
    var name = document.getElementById("name").value;
    if (name.length === 0) {
        document.getElementById("validationMessage").innerHTML = "Name can't be empty";
        return false;
    }
    if (name.length <= 2) {
        document.getElementById("validationMessage").innerHTML = "Name length must be greater than 2";
        return false;
    }
    if (/^[A-Za-z ]+$/.test(name)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = "The entered name is not valid";
        return false;
    }
}

function validateEmail() {
    var mail = document.getElementById("email").value;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    }
    document.getElementById("validationMessage").innerHTML = "Please enter a valid e-mail address!!";
    return false;
}

function validatePassword() {
    var password = document.getElementById("password").value;
    if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(password)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = "Password should contain atleast one Uppercase, Lowercase, Alphanumeric character and it should have minimum length of 8 characters!!!";
        return false;
    }
}

function validateConfirmPassword() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    if (confirmPassword.length === 0) {
        document.getElementById("validationMessage").innerHTML = "Confirm Password can't be empty";
        return false;
    } else if (confirmPassword !== password) {
        document.getElementById("validationMessage").innerHTML = "Passwords must be same!!!";
        return false;
    } else if (password === confirmPassword) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    }
}

function validateContact() {
    var contactNumber = document.getElementById("contact").value;
    if (/^[0-9]+$/.test(contactNumber)) {
        document.getElementById("validationMessage").innerHTML = "";
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = "Please enter a valid contact number!!!";
        return false;
    }
}

function validateGender() {
    if (document.getElementById("male").checked || document.getElementById("female").checked) {
        return true;
    } else {
        document.getElementById("validationMessage").innerHTML = " Please select a gender!!";
        return false;
    }
}

function validateVehicleForm() {
    if (document.getElementById("vehicleName").length !== 0 && document.getElementById("vehicleNumber").value.length !== 0) {
        if (document.getElementById("Cycle").checked || document.getElementById("MotorCycle").checked || document.getElementById("FourWheelers").checked) {
            document.getElementById("vehicleValidationMessage").innerHTML = "";
            return true;
        } else {
            document.getElementById("vehicleValidationMessage").innerHTML = "Enter proper inputs";
            return false;
        }
    } else {
        document.getElementById("vehicleValidationMessage").innerHTML = "Enter proper inputs";
        return false;
    }
}

function afterVehicleFormValidation() {
    if (validateVehicleForm()) {
        document.getElementById("vehicleForm").style.display = "none";
        document.getElementById("empForm").style.display = "none";
        document.getElementById("chooseCurrency").style.display = "block";
        if (document.getElementById("Cycle").checked) {
            document.getElementById("CyclePass").style.display = "block";
            selected = "Cycle";
            //changePrice();

        } else if (document.getElementById("MotorCycle").checked) {
            document.getElementById("MotorcyclePass").style.display = "block";
            selected = "MotorCycle";
            //changePrice();
        } else if (document.getElementById("FourWheelers").checked) {
            document.getElementById("FourWheelerPass").style.display = "block";
            selected = "FourWheelers";
            //changePrice();
        }
        return true;
    } else {
        return false;
    }
}

function changePrice() {
    if (selected === "Cycle") {
        var e = document.getElementById("currency");
        optionSelected = e.options[e.selectedIndex].text;
        if (optionSelected === "INR") {

            document.getElementById("cp1").textContent = "5 INR";
            document.getElementById("cp2").textContent = "100 INR";
            document.getElementById("cp3").textContent = "500 INR";

        } else if (optionSelected === "USD") {
            document.getElementById("cp1").textContent = "0.06 $";
            document.getElementById("cp2").textContent = "1.33 $";
            document.getElementById("cp3").textContent = "6.67 $";

        } else if (optionSelected === "YEN") {
            document.getElementById("cp1").textContent = "7.64 YEN";
            document.getElementById("cp2").textContent = "152.83 YEN";
            document.getElementById("cp3").textContent = "764.13 YEN";

        }
    } else if (selected === "MotorCycle") {
        var e = document.getElementById("currency");
        optionSelected = e.options[e.selectedIndex].text;
        if (optionSelected === "INR") {
            document.getElementById("mcp1").textContent = "10 INR";
            document.getElementById("mcp2").textContent = "200 INR";
            document.getElementById("mcp3").textContent = "1000 INR";

        } else if (optionSelected === "USD") {
            document.getElementById("mcp1").textContent = "0.13 $";
            document.getElementById("mcp2").textContent = "2.66 $";
            document.getElementById("mcp3").textContent = "13.33 $";

        } else if (optionSelected === "YEN") {
            document.getElementById("mcp1").textContent = "15.3 YEN";
            document.getElementById("mcp2").textContent = "306 YEN";
            document.getElementById("mcp3").textContent = "1530 YEN";

        }
    } else if (selected === "FourWheelers") {
        var e = document.getElementById("currency");
        optionSelected = e.options[e.selectedIndex].text;
        if (optionSelected === "INR") {
            document.getElementById("fwp1").textContent = "20 INR";
            document.getElementById("fwp2").textContent = "500 INR";
            document.getElementById("fwp3").textContent = "3500 INR";

        } else if (optionSelected === "USD") {
            document.getElementById("fwp1").textContent = "0.26 $";
            document.getElementById("fwp2").textContent = "6.66 $";
            document.getElementById("fwp3").textContent = "46.67 $";

        } else if (optionSelected === "YEN") {
            document.getElementById("fwp1").textContent = "30.6 YEN";
            document.getElementById("fwp2").textContent = "765 YEN";
            document.getElementById("fwp3").textContent = "5355 YEN";

        }
    }
}

function payMessage() {
    document.getElementById("chooseCurrency").style.display = "none";
    document.getElementById("CyclePass").style.display = "none";
    document.getElementById("FourWheelerPass").style.display = "none";
    document.getElementById("MotorcyclePass").style.display = "none";
    var list = document.getElementsByClassName('passAmount');
    var valueList = document.getElementsByClassName('passes');
    for (var index = 0; index < list.length; index++) {
        if (list[index].checked) {
            document.getElementById("vehiclePriceMessage").innerHTML = "< h2 > Pay Your Bill: " + valueList[index].textContent + " < /h2>";
        }
    }
}