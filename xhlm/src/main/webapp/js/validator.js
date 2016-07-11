
    
/**
 * 页面输入框非空校验
 * @param 属性对象  chObj 
 * @param 消息名 chMsg 
 */
function isEmpty(chObj,chMsg){
	if (chObj.val() == "") {
		alert(chMsg);
		chObj.focus();
		chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true;
}

/**
 * 页面输入框非数字校验
 * @param 属性对象  chObj 
 * @param 消息名 chMsg 
 */   
function isNum(chObj,chMsg)    
{    
     // 数字校验
	var patrn=/^[0-9]{1,20}$/;//判断字符串是否为数字      
    if (!patrn.exec(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true;  
}

/**
 * 页面输入框非金钱校验
 * @param 属性对象  chObj 
 * @param 消息名 chMsg 
 */   
function isMoney(chObj,chMsg)    
{    
	var re=/^[0-9]*(\.[0-9]{1,2})?$/;
     //判断正整数 /^[1-9]+[0-9]*]*$/      
     if (!re.test(chObj.val())) {    
        alert(chMsg);    
        chObj.focus();    
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true;    
}

/**
 * 将数值四舍五入(保留2位小数)后格式化成金额形式
 *
 * @param num 数值(Number或者String)
 * @return 金额格式的字符串,如'1,234,567.45'
 * @type String
 */
function formatMoney(num) {
    num = num.toString().replace(/\$|\,/g,'');
    if(isNaN(num))
    num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num*100+0.50000000001);
    cents = num%100;
    num = Math.floor(num/100).toString();
    if(cents<10)
    cents = "0" + cents;
    //for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
    //num = num.substring(0,num.length-(4*i+3))+','+
    //num.substring(num.length-(4*i+3));
    return (((sign)?'':'-') + num + '.' + cents);
}

/********************************** 2012-01-31追加校验开始 **************************************/
/**
* 去除多余空格函数
* trim:去除两边空格 lTrim:去除左空格 rTrim: 去除右空格
* 用法：
* var str = " hello ";
* str = str.trim();
*/
String.prototype.trim = function() {
    return this.replace(/(^[\s]*)|([\s]*$)/g, "");
};
//删除字符串左边空格   
String.prototype.lTrim = function() {
    return this.replace(/(^[\s]*)/g, "");
};
//删除字符串右边空格   
String.prototype.rTrim = function() {
    return this.replace(/([\s]*$)/g, "");
};

/**
*校验字符串是否为空
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isNull(chObj,chMsg) {
    if (null == chObj.val() || "" == chObj.val()) {
    	alert(chMsg);
    	chObj.focus();
		chObj.css('borderColor','red');
        return false; 
    }
    chObj.css('borderColor','');
	return true;
}

/**
*校验字符串是否全是数字
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isDigit(chObj,chMsg) {
    var patrn = /^\d+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true;  
}

/**
*校验字符串是否为整型
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isInteger(chObj,chMsg) {
    var patrn = /^([+-]?)(\d+)$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否为正整数
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isPlusInteger(chObj,chMsg) {
    var patrn = /^([+]?)(\d+)$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否为负整数
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isMinusInteger(chObj,chMsg) {
    var patrn = /^-(\d+)$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否为浮点数
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isFloat(chObj,chMsg) {
    var patrn = /^([+-]?)\d*\.\d+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否为正浮点数
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isPlusFloat(chObj,chMsg) {
    var patrn = /^([+]?)\d*\.\d+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否为负浮点数
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isMinusFloat(chObj,chMsg) {
    var patrn = /^-\d*\.\d+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否仅中文
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isChinese(chObj,chMsg) {
    var patrn = /[\u4E00-\u9FA5\uF900-\uFA2D]+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否仅ACSII字符
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isAcsii(chObj,chMsg) {
    var patrn = /^[\x00-\xFF]+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否手机号码
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isMobile(chObj,chMsg) {
    
    //如果手机号码不能通过验证
    if(!chObj.val().match(/^1[3|4|5|7|8][0-9]\d{4,8}$/)){ 
    	alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false;
    }
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否电话号码
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isPhone(chObj,chMsg) {
    var patrn = /^(0[\d]{2,3}-)?\d{6,8}(-\d{3,4})?$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否URL地址
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isUrl(chObj,chMsg) {
    var patrn = /^http[s]?:\/\/[\w-]+(\.[\w-]+)+([\w-\.\/?%&=]*)?$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否电邮地址
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isEmail(chObj,chMsg) {
    var patrn = /^[\w-]+@[\w-]+(\.[\w-]+)+$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}

/**
*校验字符串是否邮编
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isZipCode(chObj,chMsg) {
    var patrn = /^\d{6}$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true;  
}

/**
*校验字符串是否合法时间
*返回值：
*如果为空，定义校验通过， 返回true
*如果字串全部为数字，校验通过，返回true
*如果校验不通过， 返回false 参考提示信息：输入域必须为合法时间！
*/
function isDate(str) {
    if (!/\d{4}(\.|\/|\-)\d{1,2}(\.|\/|\-)\d{1,2}/.test(str)) {
        return false;
    }
    var r = str.match(/\d{1,4}/g);
    if (r == null) {
        return false;
    };
    var d = new Date(r[0], r[1] - 1, r[2]);
    return (d.getFullYear() == r[0] && (d.getMonth() + 1) == r[1] && d.getDate() == r[2]);
}

/**
*校验字符串：只能输入6-20个字母、数字、下划线(常用手校验用户名和密码)
* @param 属性对象   	chObj 
* @param 消息名 	    chMsg 
*/
function isString6_20(chObj,chMsg) {
    var patrn = /^(\w){6,20}$/;
    if (!patrn.test(chObj.val())){
        alert(chMsg);    
        chObj.focus();
        chObj.css('borderColor','red');
        return false; 
	}
	chObj.css('borderColor','');
	return true; 
}
/********************************** 2012-01-31追加校验结束 **************************************/
