function removeRepeatedCharacters() {
    var input = document.getElementById("inputString").value;
    if (input == "")
        alert("Input cannot be null...!!");
    else {
        document.getElementById("demo").innerHTML = input;
        var i = 0;
        while (i < input.length)
            if (i < input.length - 1 && input.charAt(i) == input.charAt(i + 1)) {
                var str1 = input.substring(0, i);
                var str2 = input.substring(i + 2, input.length);
                input = str1.concat(str2);
                console.log(input);
                i = 0;
            } else
                i++;
    }
    document.getElementById("demo").innerHTML = input;

}