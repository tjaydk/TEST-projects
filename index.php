<?php
define( 'APP_ROOT', str_replace( "\\", "/", ( __DIR__ ) ) );

use Slim\App as SlimApp;
use Slim\Container;

require 'vendor/autoload.php';

$container = new Container;

$app = new SlimApp( $container );

require 'app/BankingService/core/view/routes.php';

$app->run();