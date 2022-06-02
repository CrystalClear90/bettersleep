// Learn more https://docs.expo.io/guides/customizing-metro
const { getDefaultConfig } = require('expo/metro-config');
const config = getDefaultConfig(__dirname);

config.transformer.minifierConfig.compress.drop_console = true;

config.resolver.sourceExts.push("cjs")

module.exports = config;
