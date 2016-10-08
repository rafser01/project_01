angular.module('ngBoilerplate.display',[
    'ui.router',
    'ngBoilerplate.account'
])
        .config(function($stateProvider){
      $stateProvider.state('display',{
          url:'/display',
  views:{
      'main': {
                templateUrl:'display/display.tpl.html',
                controller: 'DisplayCtrl'
                
            }
  },
  data :{pageTitle:"Stock List"}
      });      
}).factory('displayFactory', function($http){
    return {
        grabAllStocks:function(){
            return $http.get('../display/').then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        alert('Error while grabing stock list');
                    }
                    
                    );
        },
        grabReviewsById:function(id){
            return $http.get('../reviews/'+id+'/').then(
                    function(result){
                        return result.data;
                    },
                    function(error){
                        alert('Error while fetching reviews');
                    }
                    );
        },
        addReview:function(reviewItems){
            
        }
    };
}).controller('DisplayCtrl', function($scope, accountFactory,displayFactory ){
    $scope.logout=accountFactory.logout;
    $scope.isLoggedIn=accountFactory.isLoggedIn;
    var self=this;
    self.stocks=[];
    self.grabAllStocks=function(){
        displayFactory.grabAllStocks().then(
                function(result){
                    self.stocks=result;
                },
                function(error){
                    
                }
                );
    };
    
    self.reviews=[];
    self.descriptions=[];
    self.grabReviewById=function(id){
        displayFactory.grabReviewsById(id).then(
                function(success){
                    self.reviews=success; 
                }
                );
    };
    self.grabAllStocks();
    self.setDescription=function(stockId){
      self.tab=stockId;  
    };
    self.isDescriptionTab=function(checkTab){
        return    self.tab===checkTab;
    };
    self.setReviewTab=function (stockId){
        self.grabReviewById(stockId);
        self.tab=1000+stockId;
    };
    self.isReviewTab=function(checkTab){
        return  self.tab===1000+checkTab;  
    };
    self.review={rating:'', description:'', title:''};
    self.addReview=function(){
        
    };
    });
