INSERT INTO `maendeleo_db`.`bank` (`name`, `code`) VALUES ('Maendeleo Community Bank', '0001');
INSERT INTO `maendeleo_db`.`bank` (`name`, `code`) VALUES ('KCB Bank', '0002');
INSERT INTO `maendeleo_db`.`bank` (`name`, `code`) VALUES ('Equity Bank', '0003');
INSERT INTO `maendeleo_db`.`bank` (`name`, `code`) VALUES ('Cooperative Bank', '0004');

INSERT INTO `maendeleo_db`.`branch` (`code`, `name`, `bank_id`) VALUES ('100-0001', 'Moi Avenue', '0001');
INSERT INTO `maendeleo_db`.`branch` (`code`, `name`, `bank_id`) VALUES ('100-0002', 'Kenyatta Avenue', '0002');
INSERT INTO `maendeleo_db`.`branch` (`code`, `name`, `bank_id`) VALUES ('100-0003', 'Arwing Kodhak Avenue', '0003');
INSERT INTO `maendeleo_db`.`branch` (`code`, `name`, `bank_id`) VALUES ('100-0004', 'Thika Road', '0004');

INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('1593', '00100');
INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('3415', '40814');
INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('6231', '82425');
INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('2563', '73933');
INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('7114', '84021');

INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('9383', '37484');
INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('8429', '28485');
INSERT INTO `maendeleo_db`.`postal_address` (`number`, `code`) VALUES ('2048', '00100');

INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Ngumba, Leo Street, 1A', '1', '2 years');
INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Kasarani, Thika Road, 4C', '1', '1 year');
INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Roysambu, Thika Road, 2B', '1', '10 Months');
INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Langata, Langata Road, 3G', '1', '3 years');
INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Westlands, Muthithi Road, 9A', '0', '9 years');

INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, South C, C Road, 2B', '1', '10 Months');
INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Langata, Langata Road, 7N', '1', '3 years');
INSERT INTO `maendeleo_db`.`residence` (`physical_address`, `owned`, `occupancy_duration`) VALUES ('Nairobi, Westlands, Muthithi Road, 9A', '0', '9 years');

INSERT INTO `maendeleo_db`.`member` (`identity_type`, `identity_no`, `pin_no`, `first_name`, `middle_name`, `last_name`, `dob`, `mobile_no`, `email`, `marital_status`, `dependents`, `residence_id`, `postal_address_id`) VALUES ('0', '25023590', 'PWU395NM5', 'Kevin', 'Kanyi', 'Mbugua', '05/03/1987', '0724166274', 'mbugua.kevinkanyi@gmail.com', '0', '2', '1', '1');
INSERT INTO `maendeleo_db`.`member` (`identity_type`, `identity_no`, `pin_no`, `first_name`, `middle_name`, `last_name`, `dob`, `mobile_no`, `email`, `marital_status`, `dependents`, `residence_id`, `postal_address_id`) VALUES ('0', '29385749', 'PWQ393V0B', 'Ephantus', 'Kanyi', 'Mwangi', '11/10/1970', '0721059386', 'ephantus@gmail.com', '1', '5', '2', '2');
INSERT INTO `maendeleo_db`.`member` (`identity_type`, `identity_no`, `pin_no`, `first_name`, `middle_name`, `last_name`, `dob`, `mobile_no`, `email`, `marital_status`, `dependents`, `residence_id`, `postal_address_id`) VALUES ('0', '29284049', 'PWW99MV1M', 'Peter', 'Mbugua', 'Kanoi', '27/03/1998', '0722894847', 'peter.mbugua@gmail.com', '0', '1', '3', '3');
INSERT INTO `maendeleo_db`.`member` (`identity_type`, `identity_no`, `pin_no`, `first_name`, `middle_name`, `last_name`, `dob`, `mobile_no`, `email`, `marital_status`, `dependents`, `residence_id`, `postal_address_id`) VALUES ('0', '2183938', 'PWU31BZ04L', 'Nancy', 'Moraa', 'Moraa', '15/09/1987', '0729483738', 'moraa@gmail.com', '1', '2', '4', '4');
INSERT INTO `maendeleo_db`.`member` (`identity_type`, `identity_no`, `pin_no`, `first_name`, `middle_name`, `last_name`, `dob`, `mobile_no`, `email`, `marital_status`, `dependents`, `residence_id`, `postal_address_id`) VALUES ('0', '29583920', 'PWOMX9WN', 'Jane', 'Doe', 'Doe', '29/07/1993', '0723859748', 'jane254@gmail.com', '0', '1', '5', '5');

INSERT INTO `maendeleo_db`.`account` (`number`, `name`, `branch_id`, `member_id`) VALUES ('ke-200-001-0001', 'Kevin Kanyi Mbugua', '1', '1');
INSERT INTO `maendeleo_db`.`account` (`number`, `name`, `branch_id`, `member_id`) VALUES ('ke-300-001-0001', 'Ephantus Kanyi Mwangi', '2', '2');
INSERT INTO `maendeleo_db`.`account` (`number`, `name`, `branch_id`, `member_id`) VALUES ('ke-100-001-0001', 'Peter Mbugua Kanoi', '3', '3');
INSERT INTO `maendeleo_db`.`account` (`number`, `name`, `branch_id`, `member_id`) VALUES ('ke-400-001-0001', 'Nancy Moraa Moraa', '1', '4');
INSERT INTO `maendeleo_db`.`account` (`number`, `name`, `branch_id`, `member_id`) VALUES ('ke-500-001-0001', 'Jane Doe Doe', '4', '5');

INSERT INTO `maendeleo_db`.`other_bank_loan_amount` (`currency`, `amount`, `outstanding_balance`) VALUES ('0', '200000', '90000');
INSERT INTO `maendeleo_db`.`other_bank_loan_amount` (`currency`, `amount`, `outstanding_balance`) VALUES ('0', '400000', '100000');
INSERT INTO `maendeleo_db`.`other_bank_loan_amount` (`currency`, `amount`, `outstanding_balance`) VALUES ('0', '1000000', '500000');
INSERT INTO `maendeleo_db`.`other_bank_loan_amount` (`currency`, `amount`, `outstanding_balance`) VALUES ('0', '300000', '10000');
INSERT INTO `maendeleo_db`.`other_bank_loan_amount` (`currency`, `amount`, `outstanding_balance`) VALUES ('0', '90000', '5500');

INSERT INTO `maendeleo_db`.`other_bank_loan` (`date_granted`, `repayment_period`, `bank_id`, `account_id`, `amount_id`) VALUES ('12/12/2018', '12 months', '0001', '1', '1');
INSERT INTO `maendeleo_db`.`other_bank_loan` (`date_granted`, `repayment_period`, `bank_id`, `account_id`, `amount_id`) VALUES ('12/12/2018', '12 months', '0002', '2', '2');
INSERT INTO `maendeleo_db`.`other_bank_loan` (`date_granted`, `repayment_period`, `bank_id`, `account_id`, `amount_id`) VALUES ('12/12/2018', '12 months', '0003', '3', '3');
INSERT INTO `maendeleo_db`.`other_bank_loan` (`date_granted`, `repayment_period`, `bank_id`, `account_id`, `amount_id`) VALUES ('12/12/2018', '12 months', '0003', '4', '4');
INSERT INTO `maendeleo_db`.`other_bank_loan` (`date_granted`, `repayment_period`, `bank_id`, `account_id`, `amount_id`) VALUES ('12/12/2018', '12 months', '0004', '5', '5');

INSERT INTO `maendeleo_db`.`institution` (`name`, `phone_no`, `industry`, `years_operational`, `postal_address_id`, `residence_id`) VALUES ('praoktiv-io tech ltd', '0722948567', '0', '10', '6', '6');
INSERT INTO `maendeleo_db`.`institution` (`name`, `phone_no`, `industry`, `years_operational`, `postal_address_id`, `residence_id`) VALUES ('fly high ltd', '0723849586', '4', '10', '7', '7');
INSERT INTO `maendeleo_db`.`institution` (`name`, `phone_no`, `industry`, `years_operational`, `postal_address_id`, `residence_id`) VALUES ('reach out kenya ltd', '0721947248', '2', '10', '8', '8');

INSERT INTO `maendeleo_db`.`employment_details` (`staff_no`, `designation`, `terms`, `member_id`, `institution_id`) VALUES ('1001', 'Accountant', '0', '1', '1');
INSERT INTO `maendeleo_db`.`employment_details` (`staff_no`, `designation`, `terms`, `member_id`, `institution_id`) VALUES ('1001', 'CEO', '0', '2', '2');
INSERT INTO `maendeleo_db`.`employment_details` (`staff_no`, `designation`, `terms`, `member_id`, `institution_id`) VALUES ('1001', 'IT Manager', '0', '3', '3');
INSERT INTO `maendeleo_db`.`employment_details` (`staff_no`, `designation`, `terms`, `member_id`, `institution_id`) VALUES ('1002', 'HR Manager', '0', '4', '3');
INSERT INTO `maendeleo_db`.`employment_details` (`staff_no`, `designation`, `terms`, `member_id`, `institution_id`) VALUES ('1002', 'Accountant', '0', '5', '2');

INSERT INTO `maendeleo_db`.`income_amount` (`currency`, `amount`) VALUES ('0', '50000000');
INSERT INTO `maendeleo_db`.`income_amount` (`currency`, `amount`) VALUES ('0', '38490000');
INSERT INTO `maendeleo_db`.`income_amount` (`currency`, `amount`) VALUES ('0', '90000000');

INSERT INTO `maendeleo_db`.`income` (`type`, `details`, `institution_id`, `income_amount_id`) VALUES ('0', '', '1', '1');
INSERT INTO `maendeleo_db`.`income` (`type`, `details`, `institution_id`, `income_amount_id`) VALUES ('0', '', '2', '2');
INSERT INTO `maendeleo_db`.`income` (`type`, `details`, `institution_id`, `income_amount_id`) VALUES ('0', '', '3', '3');

