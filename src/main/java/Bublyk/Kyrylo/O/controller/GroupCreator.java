package Bublyk.Kyrylo.O.controller;

import Bublyk.Kyrylo.O.model.Group;
import Bublyk.Kyrylo.O.model.Human;

public class GroupCreator {
    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}