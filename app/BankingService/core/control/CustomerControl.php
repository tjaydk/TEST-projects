<?php

namespace BankingService\core\control;

use stdClass;

class CustomerControl {

	public function getInterestRate( $amount ) {

		$res       = new stdClass();
		$res->code = 400;

		if ( ! is_numeric( $amount ) ) {
			$res->data = "Please provide a numeric amount";

			return $res;
		}

		if ( empty( $amount ) && $amount != 0 ) {
			$res->data = "Please provide an amount";

			return $res;
		}

		if ( $amount < 0 ) {
			$res->data = $amount . " is not a valid amount.";

			return $res;
		}

		$res->code = 200;

		if ( $amount <= 100 ) {
			$res->data = 3;

			return $res;
		}

		if ( $amount < 1000 ) {
			$res->data = 5;

			return $res;
		}

		$res->data = 7;

		return $res;
	}

	public function getDiscount( $values ) {

		$res       = new stdClass();
		$res->code = 400;

		if ( ! is_bool( $values['new_customer'] ) || ! is_bool( $values['loyalty_card'] ) || ! is_bool( $values['coupon'] ) ) {
			$res->data = "Missing inputs";

			return $res;
		}

		if ( $values['new_customer'] == true && $values['loyalty_card'] == true && $values['coupon'] == true ) {
			$res->data = "Invalid input";

			return $res;
		}

		if ( $values['new_customer'] == true && $values['loyalty_card'] == true && $values['coupon'] == false ) {
			$res->data = "Invalid input";

			return $res;
		}

		$res->code = 200;

		if ( $values['new_customer'] == true && $values['loyalty_card'] == false && $values['coupon'] == true ) {
			$res->data = 20;

			return $res;
		}

		if ( $values['new_customer'] == true && $values['loyalty_card'] == false && $values['coupon'] == false ) {
			$res->data = 15;

			return $res;
		}

		if ( $values['new_customer'] == false && $values['loyalty_card'] == true && $values['coupon'] == true ) {
			$res->data = 30;

			return $res;
		}

		if ( $values['new_customer'] == false && $values['loyalty_card'] == true && $values['coupon'] == false ) {
			$res->data = 10;

			return $res;
		}

		if ( $values['new_customer'] == false && $values['loyalty_card'] == false && $values['coupon'] == true ) {
			$res->data = 20;

			return $res;
		}

		if ( $values['new_customer'] == false && $values['loyalty_card'] == false && $values['coupon'] == false ) {
			$res->data = 0;

			return $res;
		}

		$res->data = "Invalid input";
		return $res;

	}
}