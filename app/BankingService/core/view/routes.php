<?php
use Slim\Http\Request as Request;
use Slim\Http\Response as Response;
use BankingService\core\control\CustomerControl as CustomerControl;

$app->post( '/api/interest_rate', function ( Request $request, Response $response, $args ) use ( $app ) {

	$body = $request->getParsedBody();

	$ctrl   = new CustomerControl();
	$result = $ctrl->getInterestRate( $body['amount'] );

	if ( $result->code != 200 ) {
		return $response->withStatus( $result->code )->withJson( $result );
	}

	return $response->withStatus(200)->withJson( $result );


} );

$app->post( '/api/discount', function ( Request $request, Response $response, $args ) use ( $app ) {

	$body   = $request->getParsedBody();
	$ctrl   = new CustomerControl();
	$result = $ctrl->getDiscount( $body );

	if ( $result->code != 200 ) {
		$response->withStatus( 400 )->withJson( $result );
	}

	return $response->withStatus(200)->withJson( $result );

} );

$app->get( '/[{path:.*}]', function ( Request $request, Response $response, $args ) use ( $app ) {

	$response->withStatus( 404, "Not Found" );
	$error       = new stdClass();
	$error->code = 404;
	$error->data = "Not Found";

	return $response->withJson( $error );
} );
