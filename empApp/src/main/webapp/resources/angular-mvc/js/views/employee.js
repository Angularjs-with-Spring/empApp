var templateUrlConfig = {
	appTemplateEntryPoint : "/angSpring/",
	employeeTemplateGroup : "/users/"
};

var employeeViewsConfig = {
		indexView : {
			header: viewHeaderFooter.header,
	  			content:{
    	      template: 'launchEmployee',
				controller: 'NewEmployeeCtrl'
    	     },
    	     footer : viewHeaderFooter.footer
		},
		homeView : {
			header: viewHeaderFooter.header,
					content:{
		      templateUrl: templateUrlConfig.appTemplateEntryPoint
						+ templateUrlConfig.employeeTemplateGroup
						+ 'launchEmployee',
				controller: 'NewEmployeeCtrl'
		     },
		     footer : viewHeaderFooter.footer
		}
	};