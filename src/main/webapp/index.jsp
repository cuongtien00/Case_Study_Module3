<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/16/2021
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>FaceBook</title>
    <link rel="stylesheet" href="css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
  <body>
    <div class="page" >
      <div class="container">
        <div class="left">
          <div class="logo">
            <div class="login">Login</div>
            <div><img class="mb-4" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAh1BMVEUYd/L///8Aa/EAb/ISePIAcvKlw/kAbfHz+P4AcPGTt/eNs/cAavEAc/IRdfKwyflnnfVgmfU6hvNuofbg6/3s8/5dmPXT4vxYlfXD1/u70fougfOcvvjn7/3Z5vypxvlNj/TM3fuDrfd4p/Y2hPMlffP2+v6Gr/dFi/S2zvrQ3/x8qfYAY/GN8zfMAAALKElEQVR4nN3d6XbiuBIAYFnCGAESECBAQiCEQIf0ff/nu8JsNl6QVFUW03Xmx5w5E/CHbam0s6iZ6ExWm8XbYXCMw9tis5pMG/pmRvvx+8mi/TV6YYLzRAghT2H+LeFcsJfXr/Zisqe9BDphZ7McvwsuZKy1ZmVh/nsszf+xGy4XHbLroBFOBuNWX0hVLitIlRT91ng9IbkWfOH0MGZcKitbNpTkejzAfzuRhavuCxeWt67sZgr+3V3hXhKmcNXbcemruyolb/UwkWjC6fKbS6DuEjF/X6I9rkjCxSv87mXD3Mn5AufSMIT7ZSvB5J1CJWyJUYfAhR9/BdbTeRdaJtuP4MLJkMc0vjRiPoKWOjDhZNR3r/jcQvVfYUaI8GPIqX3H0HwEeVb9hfuvRnzHUHzrX+Z4C9sJ5ft3HzFfNizcvAv8+qE2xM6zfvQS7oe8YR9LX0evR9VHeBBNPqC3UGLQiLAzD3ADT6GTT/d01Vl48Gj64YXHbXQVhngDs2HeRsd+HTfhqhXmDcxG3JrRCdv9sDfwHH2nutFFOOShbedIRiTC6TtRI8kj4p19pmotnAUtQ+9Diw228PAcr+A1dH+NK+z2Q5MKwXuYwm0S2lMSyRhPOBKhNaUh5ljCz+cpRPMhP3GETws0tcYPhvAnfKJWHfELXPj5zECbu/hI+MSP6CniR+/iA+Ho2YGmuHlQotYLt89ZTeRD1NeLtcLuM1b0xUhqs5s64eH5UrXy4HU5ao1w9l8Bmjbxxkc4RR3ypA0tqvvgqoXvz9QefBR65y4cNlRPaBUfJ0klxxDptKlYqYopRjURv7oK2w30yWglk35r/nc5WGx+V6vV72azOKyXf7avL+w4S8xY7alJVfdUhXBFXspoyfWwPavs/OysFuve8CXmieXb0q/oZKwQtohLGcV3ljODprOhbYFQ/muVC4ek6ba5fVuHXt2e5cVUvIqlwgPpSyhl16lj3lbIeOmYRpmwQ1kTKt5zHHiwFpbXimXCOV1NqPnceXzMWsh0WUuqREj4jCpxcPW5CFlSkqAWhXu6EXr57TMfz0Gok+JAeFFIV46KoYfPSchUccymINyQPaP8ywvoJGS8MGOjIHynekZte+FhQlZIwe+Fbap+C+F5B12F4j4/vRPuCSaKpiFdBjUhQsbvCps74RdRMaO+vYGuwnhbJ/wgKmZ0Aphd6ChkPL9uIy+0TuMdg3tU9N5Clc/Ac8IJ1S20GgbDEjKea5flhCOqWwiare0sVLkfNCucEDXspW9N6Clk/exNzAqJ3kItYevv3IU6+yZmhFQFqeyCgB7CXHGaEf4lqgs5cAmlh1Bl6sSbcE+Ur6ltyVUTC7OJzU24JOoC5m5TCXGEmTfjJmzh445R099OKNS6KFwQjRVCyxk/IRNvBeErUaOCg1dLeglvtf5FOKVK2FpQoJ/wlkddhFTljLKbfIYvvL4dF+E3VcvXaW595607fNkxrdTtH/eRtjSuJdxZuKLqf+IOi+wHP6c1/Dofvt88ywl7VOOhibVvrXA7auM/OeEO87MzoR/POztF5we7h0izrJDsIbVN2T5i/HbN+TE9CbtUD6m0Wxox9d6Goe67exnhC1U3sOVIzAtFy1S/34RU1b0RbmyAS5pmzanST4UHsgl6VpUFVTe0XF+FY7IhUW4znEaWT42uQkY2YpjYtO+pBoO0ugipuklNCAsg3den7ZqjcEA3wctGSPf1sn0W0r2GTFoIqXrAzIs4PAuJ+i+OYXMPP8l+4LQvwwg7hHPYbIRko86notwIN4TT1W2EhHPoxCIVUlVH6VdYCOnqqrShz0gLmtD3UI9SIeF7EFp4nJnByHrz0wgtNDkVo8xonkC4MsLFv3wPxZsRtikn5YcWyqURUk2hSSO0MN4a4Yhy0npooZobIVkfzTFCC/W7ERKmFE8gVEZIuogytJDxPeuQrjwIL5wy0go/vDCZsBXpStjgQvHLKFuHzyBcMNKk7QmEb+zt3xbKAzuQrhUNLxwwws5S9gzCNYJQyeroWwilqPkACbw82YYL1WjdrgybAdLqvz7GGtabiyGET+t6cIv/dSEw5zLvIbgsJRYC62tTloLrQ2IhsL/a1IfgnIZYuIX1V5ucBpyXEgt/YLWlyUvBbQtiofe8trPwF94+pBVCJ8IkKwaeS0MrnAEfMdPGB/fT0AoHwMvje3hfG63Qb4LwNdK+Nmh/Ka0Q2F+d9pdCJ+nTCoETX9M+b+i4Ba0QWA6qLcLYE6kQWpelY0/QtI1UCL24dPwQ/DNRCqHzRNIxYOg4PqkQmHefxvGhczFIhcC8m7XS2SbA5b+kQmDefVwQDJ8TRSmEJs3nOVHQfgJCITTvPs9rA85NpBSC8+4PjPmllELgcqzL/FLg1D1KITDvTifrH4Vr0C9FKYRWZJd53rCshlIIfQ0vc/VhtQ6hEJhQ6jiKMNbMEAqB9Zi+rZkBFcqEQmguclv3BEodCIXAlRiZtWugldxxb9+pDgtH9d/C8u7zam6ENaQxr47/WQiTftVfw+qKOLuGlGwdcMhx/Nw6YLKFQQGFl+1NLuvxiSYKBxTGXzkh1WMaUHi3pwLVspKAwrt9MagWP4UTFvY2IVqwHk5Y2J+GaIvrYEJ13fiaeJ+oYMKSfaJo5uyHEp4aTndCkrImlLB0v7YOxWMaSpjZyyGzb+KWIK8JJMzuv0W892UgYcXelxRb0IYR5jahzQoJDpcJI8wdOZPbRxh/Z8EgwlttXxDitzCCCPP7ieb380Z/E0MI7/bWJt6TPYSwdk929DoxgPB+L8o7IXZiE0B4vzXV/fkWyBuLNS8sdFAXzijZoX5f88LCjrAF4QK1sGlcaHHODG6N0bRQFU9hKAo7mNuINi0s2QGv5MyuAWJ52rBQtIsfX3buGuLmW80KVdkh3WXCKd5z2qyw9DSb0vMPB2jlaaPCsnPlqs6wHGElb00KS8rRauEea7StSaF2OYcU7cTqBoVVJ1dXnQe8xKkymhOKqgkTlWc647yKjQnjyiOlqs/lRknBmxL6nMsdfWDUig0Jtag+M6taGG0QSpuGhP1Ci8JKGK3hxGaEvCQdtRJGPXCB2oiw/njMWmE0hvZpNCGU9UfU1gujOXBQsQGhLDvI2V4YfcKqRXphXNZichFGPyAiuVA9PCLkoTB6gRCpher94bb2j4Wgu0gsjC0OebEQRp/+xQ2tUD56B22F0dy70iAVPipFHYTR2LfqpxRaHtVuJ4x6nj03hELbo9othSZH9boOMqHu1+WiPsJo49WYohJqUdOa8BRG051HrUEkjHf2ZyjbC6Po1b28oREKl1OwXYTR0rnBSCLsO63ScRJGM+b4pBIIlf51umY3YbQfuS1kwRcmc8cDlB2Fx3VuLheELVTlYxOowmj66XCIGLJQ/LifQ+8uNLV/Yj3AiCpUtT1OVeEjjDoj2yQOU8jnNoe4FcJLGEWLnV1zA08oW9ZZTD48haZu5DYVB5ZQce+Vqt7CqLPlj19HHKHmY68HNA1/YRRNXh8aMYSKzx0OFS4ERBhFq/mDRhVcqPqfs8efURMwoTHW30eo0Nw/mA8uNM/qNpGV1wgSasnHkOfzFHChKXO6WlTcSIBQCdX1L19ugSE08TbnpTfSWyj559vjP7UJJGEUfXR3PC5cq5dQx3zXdU9AKwJNaGL2h93fSXeh4ekvaOmSDUyhiVnvncvMIdtuQm3Kll0PkxehC018rIfqqrQXaiV5PFqjPZzXwBceY9Ueai6k1nZnWGopuB62VyTXQiM8xnTRHe1sdv4QrdfuAv/eXYJOmIbV7i20l0AsfIL4P4UPukIRd/C0AAAAAElFTkSuQmCC" alt="" width="72"
                      height="72"></div>
          </div>

          <div style="font-weight: 5000;font-size: 26px " class="eula">WELCOME!</div>
        </div>

        <div class="right">
          <svg viewBox="0 0 320 300">
            <defs>
              <linearGradient
                      inkscape:collect="always"
                      id="linearGradient"
                      x1="13"
                      y1="193.49992"
                      x2="307"
                      y2="193.49992"
                      gradientUnits="userSpaceOnUse">
                <stop
                        style="stop-color:#ff00ff;"
                        offset="0"
                        id="stop876" />
                <stop
                        style="stop-color:#ff0000;"
                        offset="1"
                        id="stop878" />
              </linearGradient>
            </defs>
            <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
          </svg>
          <form method="post" action="/login?action=login" >
            <div class="form">
              <p><c:if test="${message!=null}">
                <span>${message}</span>
              </c:if></p>
              <label for="email">Username</label>
              <input placeholder="Username" name="username" type="text" id="email">
              <label for="password">Password</label>
              <input placeholder="Password" name="password" type="password" id="password">
              <input  class="btn btn-primary" type="submit" style="color: white" id="submit" value="Sign In">
              <a href="" style="text-decoration: none"><p style="color:red;text-align: center; margin-top: 10px;margin-bottom: 10px;">Forgot Password? </p></a>
              <input  class="btn btn-primary" type="submit" value="Sign Up">
            </div>
          </form>

        </div>
      </div>
    </div>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
  <script language="javascript" src="js.js"></script>
  </body>
</html>
