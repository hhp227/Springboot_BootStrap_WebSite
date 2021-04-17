<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<h2>${ViewBag.Title}.</h2>

<form action="RegisterProcess" class="form-horizontal" method="post" role="form">
    <input name="__RequestVerificationToken" type="hidden" value="yWAZvXaFcp4rTbs02dPxUO7HAN_UkRC1lk5lf4YHLfOxhLAEpU84WXRenpDrQgV826S55n-aPC0aOqNkebg2jFHHArbeua09_rYCmU2dfCE1" />
    <h4>새 계정을 만드십시오.</h4>
    <hr />
    <div class="validation-summary-valid" data-valmsg-summary="true">
        <ul>
            <li style="display: none"></li>
        </ul>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="UserName">사용자 이름</label>
        <div class="col-md-10">
            <input class="form-control" data-val="true" data-val-required="사용자 이름 필드가 필요합니다." id="UserName" name="username" type="text" value="" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="Password">암호</label>
        <div class="col-md-10">
            <input class="form-control" data-val="true" data-val-length="암호은(는) 6자 이상이어야 합니다." data-val-length-max="100" data-val-length-min="6" data-val-required="암호 필드가 필요합니다." id="Password" name="password" type="password" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="ConfirmPassword">암호 확인</label>
        <div class="col-md-10">
            <input class="form-control" data-val="true" data-val-equalto="&#39;암호 확인&#39;과(와) &#39;암호&#39;이(가) 일치하지 않습니다." data-val-equalto-other="*.Password" id="ConfirmPassword" name="confirmPassword" type="password" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" class="btn btn-default" value="등록" />
        </div>
    </div>
</form>