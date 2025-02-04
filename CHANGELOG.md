# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.5.2] - 2022-12-28
### Fixed
- Blocklist check for capture end automata logic #3

## [0.5.1] - 2022-12-26
### Fixed
- Peripheralium compatibility
- Problems with Fuel (and other ability-centered API) not available
- Teleporting to non-existing points now returning operation failure instead of teleporting to 0, 0

## [0.5.0] - 25.10.22
### Added
- 1.19 support

## [0.4.4] - 17.10.22
### Fixed
- Chipped integration for 2.0.0 version

## [0.4.3] - 12.05.22
### Fixed
- Rail shape changing doesn't break rail placing (again, yep)

## [0.4.2] - 12.05.22
### Fixed
- Rail shape changing doesn't break rail placing, and now it is possible to change shape to ascending ones

## [0.4.1] - 11.05.22
### Changed
- Mason automata now can change rail shape to any possible shape

## [0.4.0] - 09.05.22

**BREAKING CHANGE**

Turtlematic now requires [Peripheralium](https://www.curseforge.com/minecraft/mc-mods/peripheralium/) as basic library
### Added
- Treasure enchantments for starbound enchanting automata

## [0.3.1] - 06.05.22
### Added
- Support for `up` and `down` direction for piston methods
- `isFuelConsumptionDisable` as configuration part for Fuel API

## [0.3.0] - 05.05.22
### Added
- Ability to harvest crops for husbandry automata
- Extra information about crops for husbandry automata
- Extra information about beehives for husbandry automata
- Ticking effect to husbandry automata cores (netherite and above)
- Chipped support for mason automata
- Piston and sticky piston turtles
- Traits description on automata cores
- Base automata levels: netherite, starbound and creative
- Villager automata levels: starbound and creative
- Trashing turtle

### Changed
- Default cooldown for `use` now 1 second

## [0.2.0] - 01.05.22
### Added
- Brewing automata
- Smithing automata
- Enchanting automata
- Mason automata

### Fixed
- Single entity hit login (again)
- `use` now will also perform general item use if use on block lead to nothing

## [0.1.3] - 28.04.22
### Changed
- `soulHarvest()` now have more human-readable results

## [0.1.2] - 28.04.22
### Fixed
- Single entity interaction logic