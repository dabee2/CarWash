package com.minton.carwash.util

import android.util.Patterns
import java.util.regex.Pattern


//정규식 체크 전용 클래스
object RegularExpression {

    //이메일 정규식 체크
    private val VALID_EMAIL_ADDRESS_REGEX: Pattern = Pattern.compile(
        "^([A-Z0-9._%+-]+)@([A-Z0-9.-]+)([\\.])+[A-Z]{2,6}$",
        Pattern.CASE_INSENSITIVE
    )

    // 핸드폰 번호 정규식 체크
    private val VALID_PHONE_REGEX: Pattern =
        Pattern.compile("^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})\$")

    //비밀번호 정규식 체크
    private val VALID_PWD_REGEX: Pattern =
        Pattern.compile(("(?=.*[A-Za-z])(?=.*[0-9]).{8,13}"), Pattern.CASE_INSENSITIVE)

    //닉네임 정규식 체크
    private val VALID_NICKNAME_REGEX = Pattern.compile("^[A-Za-z0-9가-힣]{1,8}$") // 8자리까지 가능

    //브랜드 특수문자 정규식 체크
    private val VALID_BRAND_REGEX = Pattern.compile("^[가-힣A-Za-z0-9]{1,100}$") // 100자리까지 가능

    //이름 정규식 체크(한글만 돼야함 - 자음 , 모음 안됨)
    private val VALID_NAME_REGEX = Pattern.compile("^[가-힣]{1,10}$") // 10자리까지 가능

    //영문명 정규식 체크(영문만 돼야함)
    private val VALID_EN_NAME_REGEX = Pattern.compile("^[A-Za-z]{1,100}$") // 100자리까지 가능

    //차량번호 정규식
    private val VALID_CAR_NUMBER = Pattern.compile("^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20]\\d{4}/*$")
    private val VALID_CAR_NUMBER2 = Pattern.compile("^[서울|부산|대구|인천|대전|광주|울산|제주|경기|강원|충남|전남|전북|경남|경북|세종]{2}\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20]\\d{4}$")

    fun isValidEmail(email: String): Boolean {
        val matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email)
        return if (matcher.find()) {
            Patterns.EMAIL_ADDRESS.matcher(email).find()
        } else {
            false
        }
    }

    //휴대폰 정규식 체크
    fun isValidPhone(phone: String): Boolean {
        val matcher = VALID_PHONE_REGEX.matcher(phone)
        return matcher.find()
    }

    //비밀번호 정규식 체크 (숫자, 영문 포함여부, 9~13자확인)
    fun isValidPassword(pwd: String): Boolean {
        val matcher = VALID_PWD_REGEX.matcher(pwd)
        return matcher.find()
    }

    //닉네임 정규식 체크 (숫자, 한글 , 영문만 가능, 특수문자 사용불가)
    fun isValidNickName(nickName: String): Boolean {
        val matcher = VALID_NICKNAME_REGEX.matcher(nickName)
        return matcher.matches()
    }

    //브랜드 정규식 체크 (숫자, 한글 , 영문만 가능, 특수문자 사용불가)
    fun isValidBrand(brand: String): Boolean {
        val matcher = VALID_BRAND_REGEX.matcher(brand)
        return matcher.matches()
    }

    //이름 정규식 체크(한글만 돼야함 - 자음 , 모음 안됨)
    fun isValidName(name: String): Boolean {
        val matcher = VALID_NAME_REGEX.matcher(name)
        return matcher.matches()
    }

    fun isValidArea(area: String): Boolean {
        val matcher = VALID_NAME_REGEX.matcher(area)
        return matcher.matches()
    }

    //영문명 정규식 체크(영문만 돼야함)
    fun isValidENNAme(enname: String): Boolean {
        val matcher = VALID_EN_NAME_REGEX.matcher(enname.replace(" ", ""))
        return matcher.matches()
    }

    fun isValidCarNumber(carNumber: String): Boolean {
        val matcher = VALID_CAR_NUMBER.matcher(carNumber)
        return if (matcher.matches()) {
            true
        } else {
            val matcher2 = VALID_CAR_NUMBER2.matcher(carNumber)
            matcher2.matches()
        }
    }
}