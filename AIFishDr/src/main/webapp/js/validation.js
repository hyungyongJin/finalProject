/**
 * http://ryanswanson.com/regexp/#start
 */
// "a001".validationID();
String.prototype.validationID = function(){
   return /^[A-Za-z0-9]{8,12}$/.test(this);
};
String.prototype.validationPWD = function(){
   return /[0-9a-zA-Z]{8,12}$/.test(this);
};
String.prototype.validationNM= function(){
	return /^[가-힣]{2,4}$/.test(this);
};
String.prototype.validationNICK= function(){
	return /^[가-힣a-zA-Z]{2,8}$/.test(this);
};
String.prototype.validationHP = function(){
	return /^01[0|1|6|7|9]-\d{3,4}-\d{4}$/.test(this);
};
String.prototype.validationMAIL = function(){
   return /[0-9a-zA-Z]{4,10}@[a-z]+\.([a-z]+){3}$/.test(this);
};
 



String.prototype.validationREGNO= function(){
	
	var moto = this.replace('-','');
	var magicNum = moto.substr(12,1);
	var checkSum = '234567892345';
	var sum = 0;
	for (var i = 0; i < 12; i++) {
		sum +=moto.charAt(i)*checkSum.charAt(i);
	}
	var finalVal = (11-(sum%11))%10;
	if (finalVal == parseInt(magicNum)) {
		return true;
	}else{
		return false;
	}
};


String.prototype.validationBIR = function(){
	return /^(19|20)\d{2}-(0|1)\d{1}-\d{2}$/.test(this);
};
String.prototype.validationBIRINCLUDETIME = function(){
	return /^(19|20)\d{2}-(0|1)\d{1}-\d{2}( [0-1]?\d|[2][0-3]):([0-5]\d):([0-5]\d)$/.test(this);
};
String.prototype.validationHOMETEL = function(){
	return /^0[1-9]{1,2}-\d{3,4}-\d{4}$/.test(this);
};
String.prototype.validationCOMTEL = function(){
	return /^0[1-9]{1,2}-\d{3,4}-\d{4}$/.test(this);
};



String.prototype.validationPID = function(){
	   return /^[A-Z][0-9]{9}$/.test(this);
	};
String.prototype.validationNUM = function(){
	return /^\d+/.test(this);
};
String.prototype.validationString = function(){
	return /^[가-힣]+/.test(this);
};

//관리자 게시판 생성시 정규식	
String.prototype.validationCheckBoardName = function(){
	return /[가-힣a-zA-Z0-9]{4,15}$/.test(this);
};
String.prototype.validationCheckBoardEngName = function(){
	return /[a-zA-Z0-9]{4,15}/.test(this);
};



String.prototype.validationBID = function(){
	   return /^[A-Z][0-9]{5}$/.test(this);
	};
	
	
