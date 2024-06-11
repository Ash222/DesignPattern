package com.learn.designpattern.creational.builder.p3;

public interface IPersonBuilder {

    static IName builder() {

        return new PersonBuilderImpl();
    }

    interface IName {

        IAddress setName(String name);
    }

    interface IAddress {

        IAadhar setAddress(String address);
    }

    interface IAadhar {

        IOptional setAadharNumber(int aadharNumber);
    }

    interface IOptional {

        IOptional setPhoneNumber(int phoneNumber);

        IOptional setGender(String gender);

        Person build();
    }
}
