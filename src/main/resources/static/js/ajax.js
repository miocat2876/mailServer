import {lastCharMerge,isNull} from './util.js'

function createQueryString(dataMap){
    let result = '';
    if(typeof(dataMap) === 'object' && !Array.isArray(dataMap)){
        const reg = /[^\w\sㄱ-힣]|[\_]/g;
        return result = '?' + Object.entries(dataMap).map(item => item.join('=')).join('&');
    }else{
        return result = '';
    }
}

const ajaxCall = () => {
    return {
        _call : function(metod,addr,data){
            return axios[metod](addr,data);
        },
        getOne  : function(addr,id){
            if(isNull(id)) throw new Error('id 값이 입력되지 않았습니다');
            addr = lastCharMerge(addr,'/');
            return this._call('get',addr + id);
        },
        getList  : function(addr,data){
            addr += createQueryString(data);
            return this._call('get',addr);
        },
        post  : function(addr,data){
            return this._call('post',addr,data);
        }
    }}

export {createQueryString,ajaxCall}