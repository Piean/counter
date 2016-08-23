/**
 * Created by mogu on 2016/8/15.
 */

$('#kaptcha_img').off().click(function () {
    $('#kaptcha_img').attr('src','/kaptcha/code_image.do?' + Math.random());
});