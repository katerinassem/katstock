/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 * Helps to render static templates from external files
 * USAGE:
 * var rendered_html;
 * render(homeView, "home", "resources/app/js/home/template/", ".html", { some : [] }, "some");
 */

var Util = (function() {

    var util = {

        renderView : function(viewInstance, templateName, templatePrefix, templateSuffix, templateData, variableName, successCallback) {

            render(templateName, templatePrefix, templateSuffix, templateData,
                function(data) {
                    var settings = {
                        variable : variableName
                    };
                    viewInstance.template = _.template(data, settings);
                    viewInstance.template = viewInstance.template(templateData);
                    viewInstance.$el.html(viewInstance.template);
                    if(successCallback) {
                        successCallback(data);
                    }
                }
            );
        },

        renderViewAfter : function(viewInstance, templateName, templatePrefix, templateSuffix, templateData, variableName, successCallback) {

            render(templateName, templatePrefix, templateSuffix, templateData,
                function(data) {
                    var settings = {
                        variable : variableName
                    };
                    viewInstance.template = _.template(data, settings);
                    viewInstance.template = viewInstance.template(templateData);
                    viewInstance.$el.append(viewInstance.template);
                    if(successCallback) {
                        successCallback();
                    }
                }
            );
        }
    };

    var render = function(templateName, templatePrefix, templateSuffix, templateData, successCallback) {

            var templateUrl = templatePrefix + templateName + templateSuffix;

            $.ajax({
                url: templateUrl,
                method: 'GET',
                success: successCallback
            });
    };

    return util;
})();