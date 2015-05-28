(function($) {

	var fu = {};
	window["FormUtil"] = fu;

	/**
	 * 获取form中所有class=""的tag
	 */
	fu.inputCheck = function(formId) {
		var form = document.getElementById(formId);
		var elements = new Array();
		var obj = {};
		var tagElements = $("#" + formId + " div.tip");
		for (var i = 0; i < tagElements.length; i++) {
			elements.push(tagElements[i]);
		}
		return elements;
	}

	/**
	 * 对form中所有elements进行正则检查
	 */
	fu.checkTag = function(elements) {
		var obj = {};
		for (var i = 0; i < elements.length; i++) {
			var divId = elements[i].id;
			var inputId = $("#" + divId).attr("input");
			
			var check = $("#" + divId).attr("check");
			var type = check.split(" ")[0];
			switch (type) {
			case "regex":
				var regex = eval(check.split(" ")[1]);
				var value = $("#" + inputId).val();

				if (value.match(regex) == null) {
					obj[divId] = divId;
				}
				break;
			case "compare":
				var compareId = check.split(" ")[1];
				var value1 = $("#" + inputId).val();
				var value2 = $("#" + compareId).val();
				if (value1 == "" || value2 == "" || value1 != value2) {
					obj[divId] = divId;
				}
				break;
			}

		}
		if (!jQuery.isEmptyObject(obj)) {
			fu.showError(obj);
			return false;
		}
		return true;
	}

	/**
	 * 显示错误信息
	 */
	fu.showError = function(obj) {
		for ( var key in obj) {
			$("#msg").html("<span>Error</span>");
			$("#msg").show();
			//setTimeout("$('#msg').hide();", 1000);
			$("#" + obj[key]).show();
			//setTimeout("$('.hidden').hide();", 1000);
		}
	}

	/**
	 * 获取form中所有elements的value
	 */
	fu.getValue = function(elements) {
		var obj = {};
		for (var i = 0; i < elements.length; i++) {
			var divId = elements[i].id;
			var inputId = $("#" + divId).attr("input");
			var value = $("#" + inputId).val();
			obj[inputId] = value;
		}
		return obj;
	}
})(jQuery);