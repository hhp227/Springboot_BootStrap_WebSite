<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>${ViewBag.Title}.</h2>

<p class="text-success">${ViewBag.StatusMessage}</p>
<div>
    <h4>Change your account settings</h4>
    <hr/>
    <dl class="dl-horizontal">
        <dt>Password:</dt>
        <dd>
            [
            <a href="Manage/ChangePassword">Change your password</a>            ]
        </dd>
        <dt>External Logins:</dt>
        <dd>
            0 [
            <a href="Manage/ManageLogins">Manage</a> ]
        </dd>
        <dt>Two-Factor Authentication:</dt>
        <dd>
            <p>
                There are no two-factor authentication providers configured. See <a href="http://blog.naver.com/hong227">this article</a>
                for details on setting up this SpringBoot application to support two-factor authentication.
            </p>
        </dd>
    </dl>
</div>