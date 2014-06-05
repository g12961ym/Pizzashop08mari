<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; utf-8" />
  <title>PersonalData Index</title>
        <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body><h1>ご注文ありがとうございました</h1><br>
  ${name}さま<br>
  ${pizza} を ${count} 枚お買い上げ<br>
  合計${price}円<br>
    <div class="center" align="center">
    <div><a href="order.html">注文ページへ</a></div>
    <div><a href="index.html">インデックス</a></div>
    </div>
  </body>
</html>