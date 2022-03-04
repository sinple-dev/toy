
const PORT = process.env.PORT || 3000;
const config = {
  SERVER() {
    return {
      host: 'localhost',
      port: PORT,
      timing: false
    }
  },
}


export default {
  // Target: https://go.nuxtjs.dev/config-target
  target: 'server',

  // 환경변수 설정하기 - https://develop365.gitlab.io/nuxtjs-0.10.7-doc/ko/api/configuration-env/
  env: {
    baseUrl: 'test baseurl',
    NODE_ENV: process.env.NODE_ENV
  },


  // 추후 dev production 분기 처리 필요
  dev: (process.env.NODE_ENV !== 'production'),

  // 웹포트 3000 고정
  server: config.SERVER(),
  srcDir: 'src/', //default directory 변경
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'web',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    '@/src/styles/main.scss'
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/typescript
    '@nuxt/typescript-build',
    '@nuxtjs/composition-api'
  ],

  router: {
    base: '/',
    middleware: 'user-agent'
  },

  axios: {
    proxy: true,
    debug: true,
    progress: true, // 로딩바를 사용 디폴트 true,
  },
  proxy: {
    '/api': {
      target: 'http://localhost:8080', // 분기 필요
      secure: false,
      changeOrigin: true
    }
  },


  // 인증,권한 설정
  auth: {

  },
  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/bootstrap
    'bootstrap-vue/nuxt',
    '@nuxtjs/axios',
    '@nuxtjs/proxy',
  ],

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  }
}
