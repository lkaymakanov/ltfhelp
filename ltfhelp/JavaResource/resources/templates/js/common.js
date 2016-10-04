
function escapeRegExp(str) {
    return str.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1");
}

function replaceAll(str, find, replace) {
  return str.replace(new RegExp(escapeRegExp(find), 'g'), replace);
}


//returns array containing object property names
function getObjectPropertyNames(obj){
	return  Object.getOwnPropertyNames(obj);
};


//returns html span with the highlighted text
function highlightTextStyle(text, textTohighlight, bhighlight, classss, style){
	if(bhighlight == false || textTohighlight ==null  || textTohighlight == '') return text;
	var highlighetdText = '<span class="' +classss +'" style="' + style + '" >' + textTohighlight + '</span>';
	return replaceAll(text, textTohighlight, highlighetdText);
};


//returns html span with the highlighted text
function highlightText(text, textTohighlight, bhighlight){
	return highlightTextStyle(text, textTohighlight, bhighlight, 'highlight', '');
};

