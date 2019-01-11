# Janity
[![Master Branch Build Status](https://travis-ci.com/etolmach/Janity.svg?branch=master)](https://travis-ci.com/etolmach/Janity/builds) 
[![codecov](https://codecov.io/gh/etolmach/Janity/branch/master/graph/badge.svg)](https://codecov.io/gh/etolmach/Janity)
[![Requirements Status](https://requires.io/github/etolmach/Janity/requirements.svg?branch=master)](https://requires.io/github/etolmach/Janity/requirements/?branch=master)

> "Bring sanity to your code"

Janity is a set of pure Java functions helping to write functional code with ease.

**Examples**

* Janity
    ```java
    List<User, List<Mesasge>> messages =
        this.getUsers()
                .stream()
                .filter(where(User::getRole).is(either(ROLE_1, ROLE_2, ROLE_3))
                        .and(User::getName).is(either(startingWith(PREFIX), endingWith(SUFFIX))))
                .flatMap(Player::getMessages)
                .filter(where(Message::getTag).is(either(TAG_1, TAG_2))
                        .and(Message::getContent).is(containing(SOME_WORD)))
                .collect(groupingBy(Message::getAuthor));
    ```

* Vanilla Java
    ```java
    List<User, List<Mesasge>> messages =
        this.getUsers()
                .stream()
                .filter(x -> x.getRole().equals(ROLE_3)
                        || x.getRole().equals(ROLE_2)
                        || x.getRole().equals(ROLE_3))
                .filter(x -> x.getName().startsWith(PREFIX)
                        || x.getName().endsWith(SUFFIX))
                .flatMap(Player::getMessages)
                .filter(x -> x.getTag().equals(TAG_1)
                        || x.getTag().equals(TAG_2))
                .filter(x -> x.getContent().contains(SOME_WORD))
                .collect(groupingBy(Message::getAuthor));
    ```