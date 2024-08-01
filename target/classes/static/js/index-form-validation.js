function validateForm(){
	
	var daysCheckBox = document.getElementById("days");
	var weeksCheckBox = document.getElementById("weeks");
	var monthsCheckBox = document.getElementById("months");
	var yearsCheckBox  = document.getElementById("years");
	var allCheckBox = document.getElementById("all");
	var form = document.getElementById('dateForm');
	var submitButton = document.getElementById("submitForm");
	
	
	if(daysCheckBox.checked || weeksCheckBox.checked || monthsCheckBox.checked || yearsCheckBox.checked || allCheckBox.checked){
		document.getElementById('errorMessage').textContent = "";
        form.submit();
    }
	else{
		document.getElementById('errorMessage').textContent = "You must select at least 1 checkbox.";
    }
}