$ ->
  $.get "/users", (users) ->
    $.each users, (index, user) ->
      $('#users').append $("<li>").html("<b>" + user.login + "</b> " + user.password)
