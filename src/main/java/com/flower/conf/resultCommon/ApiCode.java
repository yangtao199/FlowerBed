package com.flower.conf.resultCommon;

/**
 * 全局接口状态码
 * @author xfly
 */
public enum ApiCode {
  /**
   * 通用成功
   */
  API_OK(200, "ok"),
  /**
   * 用户名已存在
   */
  API_USERNAME_EXIST(1001, "禁止访问！"),
  /**
   * 未登录
   */
  API_NOLOGIN_EXISTS(1002, "未登陆！非法访问！"),
  /**
   * 参数错误
   */
  API_PARAMETER_ERROR_EXISTS(1003, "参数错误！"),
  /**
   * 登陆失败
   */
  API_LOGIN_ERROR_EXISTS(1004, "登陆失败！"),
  /**
   * 登陆失败
   */
  API_LOGIN_NOUSER_EXISTS(1005, "账号或密码错误！"),
  /**
   * 验证码错误
   */
  API_VERIFICATION_CODE_ERROR_EXISTS(1006, "验证码错误！"),
  /**
   * 验证码错误
   */
  API_VERIFICATION_CODE_OVERTIME_ERROR_EXISTS(1007, "验证码失效！"),

  /**
   * 用户已锁定，
   */
  API_USER_LOCK_ERROR_EXISTS(1008, "用户已锁定！");
  private final int code;

  private final String msg;
 
  ApiCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
 
  public int code() {
    return this.code;
  }
 
  public String getMsg() {
    return this.msg;
  }
}