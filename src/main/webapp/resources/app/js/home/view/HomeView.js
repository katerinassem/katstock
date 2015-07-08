/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */

var HomeView = Backbone.View.extend({

    el : $(Application.constants.PARTIAL_VIEW_SELECTOR),

    render : function() {

        var instance = this;
        render(
            "home",
            "resources/app/js/home/template/",
            ".html",
            {},
            function(data) {
                instance.template = data;
                instance.$el.html(instance.template);
            }
        );
        return this;
    },

    events : {
    }
});