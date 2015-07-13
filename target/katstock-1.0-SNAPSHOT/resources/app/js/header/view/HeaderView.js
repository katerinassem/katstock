/**
 * Created by katsiaryna.siamikina on 13.07.2015.
 */
var HeaderView = Backbone.View.extend({

    el: $(Application.constants.HEADER_SELECTOR),

    render: function () {

        this.userInfo = new UserInfo();

        var options = {
            error: function (data) {
                console.log(JSON.stringify(data));
            },
            success: function (data) {
                console.log(JSON.stringify(data));
            }
        };

        var instance = this;
        this.userInfo.fetch(options)
            .always(function (data) {
                console.log(JSON.stringify(data));
                Util.renderView(
                    instance,
                    "header",
                    "resources/app/js/header/temlate/",
                    ".html",
                    data,
                    "userInfo"
                );
            });
    }
});