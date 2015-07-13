/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */

var HomeView = Backbone.View.extend({

    el : $(Application.constants.PARTIAL_VIEW_SELECTOR),

    render : function() {

        Util.renderView(
            this,
            "home",
            "resources/app/js/home/template/",
            ".html",
            {}
        );
        return this;
    },

    events : {
    }
});