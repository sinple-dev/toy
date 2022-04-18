import { defineNuxtConfig } from 'nuxt3'

// https://v3.nuxtjs.org/docs/directory-structure/nuxt.config
export default defineNuxtConfig({
    typescript: {
        strict: true
    },
    publicRuntimeConfig: {
        axios: {
            baseURL: 'http://localhost:8080',
        }
    },
    modules: [
        ['@nuxtjs/axios',{proxyHeaders:false}],
        ['@nuxtjs/proxy'],
    ],
})
