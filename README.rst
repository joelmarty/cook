Cook : A recipe online handbook
###############################

What are the features ?

Recipes
=======

Ingredients are special entities, so we can search using them. When adding
a new recipe, this work with an autocomplete field: Then, on the
controller side, if the ingredient do not exists, it is added automatically.

* The recipes and the ingredients can be added periods, so it is possible to
  retrieve them by period, to know which one are "seasonish".

It is possible to add marks and comments on each recipe.

User authentication
===================

The users can be authenticated, and then can:

* Add a new recipe
* Comment without captcha

It's possible to have a look to users profiles, with an access to:

* favorite recipes
* provided recipes
* comments by this user

Controllers
===========

The controllers roles are the following:

* `Application` is the main application controller. It is possible to do things
  like searching the recipes or listing all the recipes for instance. All
  actions *do not* need to be authenticated.
* `Recipe` is the application to manage recipes (oooh!). You need to be
  authenticated to use it.
* `User` is the controller managing users.
