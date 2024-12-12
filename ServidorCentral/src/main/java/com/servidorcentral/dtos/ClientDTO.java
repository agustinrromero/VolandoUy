package com.servidorcentral.dtos;

import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;

import java.time.LocalDate;

public class ClientDTO extends UserDTO {

    private String lastName;
    private LocalDate birthday;
    private IdType idType;
    private String idNumber;
    private Country country;

    private ClientDTO(ClientDTOBuilder builder) {
        super(builder);
        this.lastName = builder.lastName;
        this.birthday = builder.birthday;
        this.idType = builder.idType;
        this.idNumber = builder.idNumber;
        this.country = builder.country;
    }

	public String getLastName() {
		return this.lastName;
	}

	public LocalDate getBirthday() {
		return this.birthday;
	}

	public IdType getIdType() {
		return this.idType;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public Country getCountry() {
		return this.country;
	}

    // Builder
    public static class ClientDTOBuilder extends UserDTOBuilder<ClientDTOBuilder> {
        private String lastName;
        private LocalDate birthday;
        private IdType idType;
        private String idNumber;
        private Country country;

        public ClientDTOBuilder(String name, String email) {
            super(name, email);
        }

        public ClientDTOBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ClientDTOBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public ClientDTOBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public ClientDTOBuilder setIdNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public ClientDTOBuilder setCountry(Country country) {
            this.country = country;
            return this;
        }

        @Override
        protected ClientDTOBuilder self() {
            return this;
        }

        @Override
        public ClientDTO build() {
            return new ClientDTO(this);
        }
    }

}

