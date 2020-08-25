//Wait for the DOM to be ready
$(function() {
//$().ready(function() {
	$("#planCreation").validate({
		/** 
		 * Specify validation rules 
		 */
		rules: {
			/**
			 * The key name on the left side is the name attribute
			 * of an input field. Validation rules are defined
			 * on the right side 
			 */

			planName: {
				required: true,
				minlength: 5
			},
			planDescription: {
				required: true,
				minlength: 5
			},
			planStartDate: {
				required: true,
				date: true
			},
			planEndDate: {
				required: true,
				date: true
			}
		},
		// Specify validation error messages
		messages: {
			planName: {
				required: " *Please provide a Plan Name",
				minlength: "must contains 5 chars"
			},
			planDescription: {
				required: " *Please provide a Plan Description",
				minlength: "must contains 5 digits"
			},
			planStartDate: {
				required: " *required: Plz Select Plan Start Date",
				date: "Format: yy-mm-dd"
			},
			planEndDate: {
				required: " *required: Plz Select Plan End Date",
				date: "Format: yy-mm-dd"
			}
		},
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler: function(form) {
			form.submit();
		}
	});
});